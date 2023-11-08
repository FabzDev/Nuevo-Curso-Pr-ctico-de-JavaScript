/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 *
 * @author fabio
 */
public class URLReader {
    public static void main(String[] args) throws Exception {
        URI oracleURI = new URI("https://www.oracle.com");
        URL oracleURL = oracleURI.toURL();
        BufferedReader br = new BufferedReader(new InputStreamReader(oracleURL.openStream()));
        String inputLine;
        while((inputLine = br.readLine()) != null){
            System.out.println(inputLine);
        }
    }
    
}
