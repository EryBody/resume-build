/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class JConnect {

    public Connection getNewConnection() {

          //Localhost connection String
//        Connection conn = null;
//        String connectionString = "jdbc:mysql://localhost:3306/resume_build_db";
//        String driver = "com.mysql.jdbc.Driver";
//        String username = "root", password = "password";
        
        //Server connection String
        Connection conn = null;
        String connectionString = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_6035cdf5808c759";
        String driver = "com.mysql.jdbc.Driver";
        String username = "bd3903ab5eada6", password = "d9217b36";

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(connectionString, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(JConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    public static void main(String args[]) {

        JConnect connect = new JConnect();
        System.out.println("Connection Instance: " + connect.getNewConnection());
    }
}
