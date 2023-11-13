/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.sockets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author fabio
 */
public class NasdaqReader2 {

    private static final String NASDAQLISTFILE = "C:/TheJavaPathV2/nasdaqTrader.txt";

    private static InputStream getServerInputStream() throws IOException, URISyntaxException {
        URI nas = new URI("ftp://ftp.nasdaqtrader.com/SymbolDirectory/nasdaqlisted.txt");
        URL nasdaq = nas.toURL();
        return nasdaq.openStream();
    }

    private static void createNasdaqFile(File f) throws IOException, URISyntaxException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(getServerInputStream())); PrintWriter pr = new PrintWriter(f)) {
            String stringLine;
            while ((stringLine = in.readLine()) != null) {
                pr.println(stringLine);
            }
        }
    }

    public static InputStream getInputStream() throws IOException, URISyntaxException {
        File f = new File(NASDAQLISTFILE);
        if (!f.exists()) {
            createNasdaqFile(f);
        }
        URL url = new URL("file:///" + NASDAQLISTFILE);
        return url.openStream();
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        BufferedReader in = new BufferedReader(new InputStreamReader(getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}
