/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.fabzdev.enums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabio
 */
public enum DBConnection {
    DEV("org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/c:/TheJavaPathV2/javaPathDB", "admin", "1234"),
    TEST("org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/c:/TheJavaPathV2/javaPathTest", "admin", "1234"),
    PROD("org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/c:/TheJavaPathV2/javaPathProd", "admin", "1234");

    private String driver;
    private String url;
    private String user;
    private String pass;

    private DBConnection(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            return null;
        }
        return DriverManager.getConnection(url, user, pass);

    }

}
