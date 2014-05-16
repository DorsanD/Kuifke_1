/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectie {

        
    //variabelen initialiseren voor connectie
    String user = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost";
    String driver = "com.mysql.jdbc.Driver";
    
    //connectie opzetten
    public Connection initCon() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return getConnection();
        
    }

    //connecteren met de juist gegevens
    private java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}