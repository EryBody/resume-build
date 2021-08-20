/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class RegisterDAO {
    
    Connection connect = null;
    JConnect jconnect = new JConnect();
    
     public int addUser(RegisterBean bean) {

        int status = -1;
        String query = "insert into registers values(?,?,?,?,?,?)";
        PreparedStatement ps = null;

        connect = jconnect.getNewConnection();

        try {
            ps = connect.prepareStatement(query);
            ps.setInt(1, bean.getId());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getName());
            ps.setString(4, bean.getSubject());
            ps.setString(5, bean.getMessage());
            ps.setString(6, bean.getEntryDate());

            int count = ps.executeUpdate();
            
            if (count == 1) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
}
