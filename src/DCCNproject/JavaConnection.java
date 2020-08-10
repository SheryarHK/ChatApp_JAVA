package DCCNproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sheryar Hassan Khan
 */

import java.sql.*;
import javax.swing.JOptionPane;
public class JavaConnection {

    
static Connection connect()
{
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dccn","root","");
    return conn;
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Make sure Mysql pw.println(userName + \" > \" + nextSend);\n" +
"            pw.close();\n" +
"             is running");
        System.exit(0);
    }
    return null;
}

    
    
}
