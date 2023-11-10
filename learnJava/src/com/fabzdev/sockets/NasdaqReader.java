/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 *
 * @author fabio
 */
public class NasdaqReader {
    public static void main(String[] args) throws Exception {
        URI nas = new URI("ftp://ftp.nasdaqtrader.com/SymbolDirectory/nasdaqlisted.txt");
        URL nasdaq = nas.toURL();
        BufferedReader br = new BufferedReader(new InputStreamReader(nasdaq.openStream()));
        String stringLine;
        while((stringLine = br.readLine()) != null)
            System.out.println(stringLine);
    }
}
