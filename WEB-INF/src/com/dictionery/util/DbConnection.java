/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionery.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
    
    public Connection getDatabaseConnection(){
        String dburl = "jdbc:mysql://localhost:3306/entries";
        String username = "root";
        String password = "root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(dburl, "keith", "mumsql");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, username, password);
            
        } catch (Exception ex) {
            // handle the error
            throw new IllegalStateException("Cannot connect to the database!", ex);
        }
        
        return conn;
    
    }
}
