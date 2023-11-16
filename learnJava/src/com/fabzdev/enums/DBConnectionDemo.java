/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.enums;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabio
 */
public class DBConnectionDemo {

    public static void main(String[] args) {
        try{
        Connection con = DBConnection.DEV.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
