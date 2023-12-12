/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.sockets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fabio
 */
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/c:/TheJavaPathV2/javaPathDB");
            
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from tableB");
            
            while(rs.next()){
                System.out.println( "Id: "+ rs.getInt("id_tableB") + "  Code: " +rs.getString("code"));
            }
            
            con.close();
        } catch (SQLException ex) {
            System.out.println("Clase no encontrada: " + ex.getMessage());
        }
        
    }
}
