/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCCNproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.omg.CORBA.portable.InputStream;

/**
 *
 * @author Sheryar Hassan Khan
 */
public class DashBoard extends javax.swing.JFrame {

    static String message;
    public static final String host = "localhost";
    public static final int portNumber = 15915;
    public static String nickname;
    private Scanner userInputScanner;

    public static int isPrivate = 0;
    Connection conn;
    String Username;
    String Password;
    ServerThread serverThread;
    Thread serverAccessThread;
    Thread RefreshTextArea;
    Socket socket;
    String UsnerNick;
            

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {

        initComponents();
        conn = JavaConnection.connect();

    }
    // retrive karo file name agar usmae nam sheryar ka hau to

    public void retrieveChat() {
        try {
            if (isPrivate == 1) {
                File file = new File("privateChat.txt");

//                Scanner scan = new Scanner(file);
//                while (scan.hasNextLine()) {
//                    String message = scan.nextLine();
//                    TEXTAREA.append(message + "\n");
//
//                }
                if (!file.exists()) {
//                    File file = new File("privateChat.txt");
                    file.createNewFile();
                }
                Scanner scan = new Scanner(file);

                while (scan.hasNextLine()) {
                    String message = scan.nextLine();

                    boolean isFound1 = message.contains(UsnerNick); //true
                    boolean isFound2 = message.contains(nickname); //true

                    if (isFound1 == true && isFound2 == true) {
                        TEXTAREA.append("\n" + message);

                    }
                }

            } else if (isPrivate == 0) {
                File file = new File("Chatroom.txt");
                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    String message = scan.nextLine();
                    TEXTAREA.append(message + "\n");

                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DashBoard(String Username, String Password) {
        super("Dashboard");
        initComponents();
        conn = JavaConnection.connect();
        this.Username = Username;
        this.Password = Password;
        getInfo();

    }

    public void mainFunction(String username) {
        try {
            String readName = Username;
            // Scanner scan = new Scanner(System.in);
            socket = new Socket(host, portNumber);

            serverThread = new ServerThread(socket, UsnerNick, portNumber); //nickname dal rah
//            ValidateThread vt= new ValidateThread(socket,Username, Password);
//            RefreshTextArea = new Thread(vt);
//            RefreshTextArea.start();
            serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();

        } catch (IOException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getInfo() {
        try {
            String sql = " select * from users where username =? and password =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Username);
            ps.setString(2, Password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nickname = rs.getString(4);
                NICKNAME.setText(nickname);
                USERNAME.setText(Username);
                PASSWORD.setText(Password);
                String name = rs.getString(5);
                NAME.setText(name);

                String welcomeName = name.toUpperCase();
                WelcomeName.setText(welcomeName);
                nickname = SEARCHNICKNAME.getText();
                UsnerNick =  rs.getString(4);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        parentPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        WelcomeName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        UpdatePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        USERNAME = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        NAME = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        NICKNAME = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        ColorChooser = new javax.swing.JPanel();
        jColorChooser1 = new javax.swing.JColorChooser();
        jButton10 = new javax.swing.JButton();
        PrivateChatPanel = new javax.swing.JPanel();
        NEWMESSAGEFIELD = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TEXTAREA = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        PrivateName = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        IMAGE2 = new javax.swing.JLabel();
        ProfilePic2 = new javax.swing.JLabel();
        SearchPanel = new javax.swing.JPanel();
        SEARCHNICKNAME = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Chatroom = new javax.swing.JPanel();
        PrivateChatPanel2 = new javax.swing.JPanel();
        NEWMESSAGEFIELD1 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TEXTAREA1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        IMAGE = new javax.swing.JLabel();
        ProfilePic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 13)); // NOI18N
        jButton1.setText("UPDATE PROFILE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 13)); // NOI18N
        jButton2.setText("DELETE PROFILE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 13)); // NOI18N
        jButton3.setText("PRIVATE CHAT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 13)); // NOI18N
        jButton4.setText("PUBLIC CHAT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        parentPanel2.setBackground(new java.awt.Color(255, 255, 255));
        parentPanel2.setLayout(new java.awt.CardLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 48)); // NOI18N
        jLabel1.setText("WELCOME");

        WelcomeName.setFont(new java.awt.Font("Magneto", 1, 48)); // NOI18N
        WelcomeName.setText("...");

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 1, 48)); // NOI18N
        jLabel5.setText("DCCN SEMESTER PROJECT");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(73, 73, 73))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(WelcomeName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(182, 182, 182)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WelcomeName))
                .addContainerGap(352, Short.MAX_VALUE))
        );

        parentPanel2.add(jPanel6, "card6");

        UpdatePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel3.setText("USERNAME");

        USERNAME.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel4.setText("PASSWORD");

        PASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PASSWORDActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel12.setText("NAME");

        NAME.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel11.setText("NICK NAME");

        Update.setText("UPDATE");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jButton6.setText("BACK");

        javax.swing.GroupLayout UpdatePanelLayout = new javax.swing.GroupLayout(UpdatePanel);
        UpdatePanel.setLayout(UpdatePanelLayout);
        UpdatePanelLayout.setHorizontalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePanelLayout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UpdatePanelLayout.createSequentialGroup()
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel12)))
                        .addGap(35, 35, 35)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(USERNAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PASSWORD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NICKNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                .addGap(172, 172, 172))
        );
        UpdatePanelLayout.setVerticalGroup(
            UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePanelLayout.createSequentialGroup()
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22)
                .addGroup(UpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(NICKNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(Update)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        parentPanel2.add(UpdatePanel, "card5");

        ColorChooser.setBackground(new java.awt.Color(51, 51, 51));

        jColorChooser1.setBackground(new java.awt.Color(51, 51, 51));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Select");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ColorChooserLayout = new javax.swing.GroupLayout(ColorChooser);
        ColorChooser.setLayout(ColorChooserLayout);
        ColorChooserLayout.setHorizontalGroup(
            ColorChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ColorChooserLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(ColorChooserLayout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ColorChooserLayout.setVerticalGroup(
            ColorChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColorChooserLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton10)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        parentPanel2.add(ColorChooser, "card7");

        PrivateChatPanel.setBackground(new java.awt.Color(255, 255, 255));

        NEWMESSAGEFIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEWMESSAGEFIELDActionPerformed(evt);
            }
        });

        jButton7.setText("SEND");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        TEXTAREA.setColumns(20);
        TEXTAREA.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        TEXTAREA.setRows(5);
        jScrollPane1.setViewportView(TEXTAREA);

        jLabel7.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        jLabel7.setText("PRIVATE CHAT WITH");

        PrivateName.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        PrivateName.setText("...");

        jButton8.setText("CHANGE COLOR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("SEND IMAGE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton13.setText("REFRESH");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton11.setText("IMAGE");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PrivateChatPanelLayout = new javax.swing.GroupLayout(PrivateChatPanel);
        PrivateChatPanel.setLayout(PrivateChatPanelLayout);
        PrivateChatPanelLayout.setHorizontalGroup(
            PrivateChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrivateChatPanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(IMAGE2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PrivateChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrivateChatPanelLayout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11))
                    .addComponent(NEWMESSAGEFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
            .addGroup(PrivateChatPanelLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(PrivateName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PrivateChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PrivateChatPanelLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(ProfilePic2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(636, Short.MAX_VALUE)))
        );
        PrivateChatPanelLayout.setVerticalGroup(
            PrivateChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrivateChatPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PrivateChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PrivateName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(PrivateChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMAGE2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(NEWMESSAGEFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(PrivateChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton13)
                    .addComponent(jButton11))
                .addGap(31, 31, 31))
            .addGroup(PrivateChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrivateChatPanelLayout.createSequentialGroup()
                    .addContainerGap(501, Short.MAX_VALUE)
                    .addComponent(ProfilePic2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(63, 63, 63)))
        );

        parentPanel2.add(PrivateChatPanel, "card6");

        SearchPanel.setBackground(new java.awt.Color(255, 255, 255));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jButton5.setText("Search ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Search Nickname ");

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 1, 48)); // NOI18N
        jLabel6.setText("Search Users By Nickname");

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(SEARCHNICKNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(317, 317, 317))))
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SearchPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(112, 112, 112)
                        .addComponent(SEARCHNICKNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(110, 110, 110)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        parentPanel2.add(SearchPanel, "card3");

        PrivateChatPanel2.setBackground(new java.awt.Color(255, 255, 255));

        NEWMESSAGEFIELD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEWMESSAGEFIELD1ActionPerformed(evt);
            }
        });

        jButton14.setText("SEND");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        TEXTAREA1.setColumns(20);
        TEXTAREA1.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        TEXTAREA1.setRows(5);
        jScrollPane3.setViewportView(TEXTAREA1);

        jLabel9.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        jLabel9.setText("CHAT ROOM");

        jButton15.setText("CHANGE COLOR");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("SEND IMAGE");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("REFRESH");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton12.setText("IMAGE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PrivateChatPanel2Layout = new javax.swing.GroupLayout(PrivateChatPanel2);
        PrivateChatPanel2.setLayout(PrivateChatPanel2Layout);
        PrivateChatPanel2Layout.setHorizontalGroup(
            PrivateChatPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrivateChatPanel2Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrivateChatPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PrivateChatPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(PrivateChatPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrivateChatPanel2Layout.createSequentialGroup()
                        .addComponent(jButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NEWMESSAGEFIELD1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
        PrivateChatPanel2Layout.setVerticalGroup(
            PrivateChatPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrivateChatPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel9)
                .addGap(46, 46, 46)
                .addGroup(PrivateChatPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrivateChatPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(NEWMESSAGEFIELD1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(PrivateChatPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton14)
                            .addComponent(jButton15)
                            .addComponent(jButton16)
                            .addComponent(jButton17)
                            .addComponent(jButton12))
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(PrivateChatPanel2Layout.createSequentialGroup()
                        .addComponent(IMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout ChatroomLayout = new javax.swing.GroupLayout(Chatroom);
        Chatroom.setLayout(ChatroomLayout);
        ChatroomLayout.setHorizontalGroup(
            ChatroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChatroomLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(PrivateChatPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ChatroomLayout.setVerticalGroup(
            ChatroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PrivateChatPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        parentPanel2.add(Chatroom, "card2");

        getContentPane().add(parentPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PASSWORDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PASSWORDActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            String username = USERNAME.getText();
            String password = PASSWORD.getText();
            String name = NAME.getText();
            String nickname = NICKNAME.getText();

            String sql = "Update users set nickname = ?, password =? where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nickname);
            ps.setString(2, password);
            ps.setString(3, username);

            int i = JOptionPane.showConfirmDialog(rootPane, "Sure?");
            if (i == 0) {

                ps.executeUpdate();
                JOptionPane.showMessageDialog(parentPanel2, "Profile Updated!");
            } else {
                JOptionPane.showMessageDialog(parentPanel2, "Profile not updated!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_UpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        parentPanel2.removeAll();
        parentPanel2.add(UpdatePanel);
        parentPanel2.repaint();
        parentPanel2.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:

            String sql = "delete from users where username= ? and password=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Username);
            statement.setString(2, Password);

            int i = JOptionPane.showConfirmDialog(rootPane, "Sure?");
            if (i == 0) {
                statement.execute();
                JOptionPane.showMessageDialog(parentPanel2, "Account Deleted!");

                setVisible(false);
                new GUI().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(parentPanel2, "Account not deleted");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            nickname = SEARCHNICKNAME.getText();

            if (!nickname.isEmpty()) {

                String sql = "SELECT * from users where nickname = ?";
                PreparedStatement statment = conn.prepareStatement(sql);
                statment.setString(1, nickname);
                ResultSet rs = statment.executeQuery();

                if (rs.next()) {

                    int i = JOptionPane.showConfirmDialog(parentPanel2, "User Exits!\nDo you want to proceed for Private Chat?");
                    if (i == 0) {
                        parentPanel2.removeAll();
                        parentPanel2.add(PrivateChatPanel);
                        parentPanel2.repaint();
                        parentPanel2.revalidate();

                        isPrivate = 1;
                        retrieveChat();
                        mainFunction(Username);
                        PrivateName.setText(rs.getString(5));
                    } else {
                        SEARCHNICKNAME.setText("");
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "No such User exists!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please fill all the required fields");
            }

        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        parentPanel2.removeAll();
        parentPanel2.add(SearchPanel);
        parentPanel2.repaint();
        parentPanel2.revalidate();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void NEWMESSAGEFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEWMESSAGEFIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NEWMESSAGEFIELDActionPerformed

    public void refreshTA() {
        TEXTAREA.setText("");
        try {
            File file = new File("privateChat.txt");

            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String message = scan.nextLine();

                boolean isFound1 = message.contains(UsnerNick); //true
                boolean isFound2 = message.contains(nickname); //true

                if (isFound1 == true && isFound2 == true) {
                    TEXTAREA.append("\n" + message);

                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refreshTA2() {
        try {
            TEXTAREA1.setText("");
            File file = new File("Chatroom.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String message = scan.nextLine();

                TEXTAREA1.append("\n" + message);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here

        TEXTAREA.setText("");

        message = NEWMESSAGEFIELD.getText();
        if (serverAccessThread.isAlive()) {

            if (!message.isEmpty()) {

                serverThread.addNextMessage(message);
                NEWMESSAGEFIELD.setText("");

            }
        }

        refreshTA();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        refreshTA();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void NEWMESSAGEFIELD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEWMESSAGEFIELD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NEWMESSAGEFIELD1ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        TEXTAREA1.setText("");

        message = NEWMESSAGEFIELD1.getText();
        if (serverAccessThread.isAlive()) {

            if (!message.isEmpty()) {

                serverThread.addNextMessage(message);
                NEWMESSAGEFIELD1.setText("");

            }
        }

        refreshTA2();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        refreshTA2();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        isPrivate = 0;
        retrieveChat();
        parentPanel2.removeAll();
        parentPanel2.add(Chatroom);
        parentPanel2.revalidate();
        parentPanel2.repaint();
        mainFunction(Username);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
//       parentPanel2.removeAll();
//       parentPanel2.add(ColorChooser);
//       parentPanel2.revalidate();
        Color c = JColorChooser.showDialog(null, "Change color!", Color.white);

        TEXTAREA.setBackground(c);
        PrivateChatPanel.setBackground(c);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

        // TEXTAREA.setBackground(c);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        Color c = JColorChooser.showDialog(null, "Change color!", Color.white);

        TEXTAREA1.setBackground(c);
        Chatroom.setBackground(c);
        PrivateChatPanel2.setBackground(c);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser c = new JFileChooser();

            FileFilter imageFilter = new FileNameExtensionFilter(
                    "Image files", ImageIO.getReaderFileSuffixes());

            c.setFileFilter(imageFilter);

            int rVal = c.showOpenDialog(this);

            File f = c.getSelectedFile();

            String filepath = f.getPath();
            //File image = new File(filepath);
            OutputStream os = socket.getOutputStream();
            BufferedImage img = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg png", baos);
            os.write(baos.toByteArray());
            //ImageIcon iconLogo = new ImageIcon(filepath);
            JOptionPane.showMessageDialog(parentPanel2, "Image sent!");
            Image newImage = img.getScaledInstance(128, 107, Image.SCALE_DEFAULT);
            IMAGE.setIcon(new ImageIcon(newImage));
            os.flush();

        } catch (IOException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        try {
            JFileChooser c = new JFileChooser();

            FileFilter imageFilter = new FileNameExtensionFilter(
                    "Image files", ImageIO.getReaderFileSuffixes());

            c.setFileFilter(imageFilter);

            int rVal = c.showOpenDialog(this);

            File f = c.getSelectedFile();

            String filepath = f.getPath();
            //File image = new File(filepath);
            OutputStream os = socket.getOutputStream();
            BufferedImage img = ImageIO.read(f);

            //ImageIcon iconLogo = new ImageIcon(filepath);
            JOptionPane.showMessageDialog(parentPanel2, "Image sent!");
            Image newImage = img.getScaledInstance(128, 107, Image.SCALE_DEFAULT);
            ProfilePic.setIcon(new ImageIcon(newImage));
            os.flush();

        } catch (IOException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        try {
            JFileChooser c = new JFileChooser();

            FileFilter imageFilter = new FileNameExtensionFilter(
                    "Image files", ImageIO.getReaderFileSuffixes());

            c.setFileFilter(imageFilter);

            int rVal = c.showOpenDialog(this);

            File f = c.getSelectedFile();

            String filepath = f.getPath();
            //File image = new File(filepath);
            OutputStream os = socket.getOutputStream();
            BufferedImage img = ImageIO.read(f);

            //ImageIcon iconLogo = new ImageIcon(filepath);
            JOptionPane.showMessageDialog(parentPanel2, "Image sent!");
            Image newImage = img.getScaledInstance(128, 107, Image.SCALE_DEFAULT);
            ProfilePic2.setIcon(new ImageIcon(newImage));
            os.flush();

        } catch (IOException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser c = new JFileChooser();

            FileFilter imageFilter = new FileNameExtensionFilter(
                    "Image files", ImageIO.getReaderFileSuffixes());

            c.setFileFilter(imageFilter);

            int rVal = c.showOpenDialog(this);

            File f = c.getSelectedFile();

            String filepath = f.getPath();
            //File image = new File(filepath);
            OutputStream os = socket.getOutputStream();
            BufferedImage img = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg png", baos);
            os.write(baos.toByteArray());
            //ImageIcon iconLogo = new ImageIcon(filepath);
            JOptionPane.showMessageDialog(parentPanel2, "Image sent!");
            Image newImage = img.getScaledInstance(128, 107, Image.SCALE_DEFAULT);
            IMAGE2.setIcon(new ImageIcon(newImage));
            os.flush();

        } catch (IOException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Chatroom;
    private javax.swing.JPanel ColorChooser;
    private javax.swing.JLabel IMAGE;
    private javax.swing.JLabel IMAGE2;
    private javax.swing.JTextField NAME;
    private javax.swing.JTextField NEWMESSAGEFIELD;
    private javax.swing.JTextField NEWMESSAGEFIELD1;
    private javax.swing.JTextField NICKNAME;
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JPanel PrivateChatPanel;
    private javax.swing.JPanel PrivateChatPanel2;
    private javax.swing.JLabel PrivateName;
    private javax.swing.JLabel ProfilePic;
    private javax.swing.JLabel ProfilePic2;
    private javax.swing.JTextField SEARCHNICKNAME;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JTextArea TEXTAREA;
    private javax.swing.JTextArea TEXTAREA1;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JButton Update;
    private javax.swing.JPanel UpdatePanel;
    private javax.swing.JLabel WelcomeName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel parentPanel2;
    // End of variables declaration//GEN-END:variables
}
