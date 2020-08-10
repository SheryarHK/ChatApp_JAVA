/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCCNproject;

/**
 *
 * @author Sheryar Hassan Khan
 */
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import DCCNproject.DashBoard;
import java.awt.TextArea;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread implements Runnable {

    private Socket socket;

    private boolean isAlived;
    private final LinkedList<String> messagesToSend;
    private boolean hasMessages = false;
    private String userName;
    private String password;
    private int port;

    public ServerThread(Socket socket, String userName, int port) {
        this.socket = socket;
        this.userName = userName;
        messagesToSend = new LinkedList<String>();
        this.port = port;
    }

    public void addNextMessage(String message) {
        synchronized (messagesToSend) {
            hasMessages = true;
            messagesToSend.push(message);
        }
    }

    public void writeFile(String message) {

        try {
            if (DCCNproject.DashBoard.isPrivate == 1) {

                File file = new File("privateChat.txt");
                if (!file.exists()) {
//                    File file = new File("privateChat.txt");
                    file.createNewFile();
                }
                
                FileWriter fw = new FileWriter(file, true);
                PrintWriter pw = new PrintWriter(fw, true);
                pw.println(userName + " -> " + DCCNproject.DashBoard.nickname + " : " + message);

                pw.close();
            } else if (DCCNproject.DashBoard.isPrivate == 0) {
                File file = new File("Chatroom.txt");
                FileWriter fw = new FileWriter(file, true);
                PrintWriter pw = new PrintWriter(fw, true);
                pw.println(userName + " > " + message);

                pw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        System.out.println("Welcome :" + userName);

        System.out.println("Local Port :" + socket.getLocalPort());
        System.out.println("Server = " + socket.getRemoteSocketAddress() + ":" + socket.getPort());
        System.out.println("GUI thread Started!");

        try {
            System.out.println("Chat room");
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), false);
            InputStream serverInStream = socket.getInputStream();

            Scanner serverIn = new Scanner(serverInStream);

            while (!socket.isClosed()) {
                if (serverInStream.available() > 0) {
                    if (serverIn.hasNextLine()) {
                        System.out.println(serverIn.nextLine());
                    }
                }
                if (hasMessages) {

                    String nextSend = "";
                    synchronized (messagesToSend) {
                        nextSend = messagesToSend.pop();
                        hasMessages = !messagesToSend.isEmpty();
                    }

                    serverOut.println(userName + " > " + nextSend);
                    writeFile(nextSend);

                    serverOut.flush();

                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
