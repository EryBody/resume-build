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

        Connection conn = null;
        String username = "";
        String password = "";
        String port = "";
        String jdbUrl = "";

        try {
            URI jdbUri = new URI(System.getenv("mysql://ys0syy3uh3vvd0xm:ldhpz3jv6xmmce10@tvcpw8tpu4jvgnnq.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/ngr5fyckqu30nm6q"));
            username = jdbUri.getUserInfo().split(":")[0];
            password = jdbUri.getUserInfo().split(":")[1];
            port = String.valueOf(jdbUri.getPort());
            jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();

            conn = DriverManager.getConnection(jdbUrl, username, password);
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    public Connection getConnection() {

        Connection conn = null;
        String connectionString = "jdbc:mysql://localhost:3306/resume_build_db";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root", password = "password";

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
        System.out.println("Connection Instance: " + connect.getConnection());
        System.out.println("Connection Instance: " + connect.getNewConnection());
    }
}
