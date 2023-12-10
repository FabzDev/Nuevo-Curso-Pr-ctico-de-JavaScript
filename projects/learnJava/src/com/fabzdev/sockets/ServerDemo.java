/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author fabio
 */
public class ServerDemo {

    private ServerSocket server;
    int nCount = 0;

    public ServerDemo() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shuting down");
            stop();
        }));}

    public void dispatchClient(Socket client) {
        Thread t = new Thread(()->{
            try {
            PrintWriter pr = new PrintWriter(client.getOutputStream());
            pr.printf("Hola Mundo\nEres el cliente #%d\n", ++nCount);
            pr.close();
            System.out.println("Conexión atentida");
        } catch (IOException ex) {
            System.out.println("Error al enviar informacion al cliente: " + ex.getMessage());
        }
        });
        t.start();
    }

    public void run() {
        try {
            server = new ServerSocket(8080);
        } catch (IOException ex) {
            System.out.println("Error al crear el Socket Server" + ex.getMessage());
            return;
        }
        System.out.printf("Server Socket iniciado en el puerto %d.\n", server.getLocalPort());
        while (true) {
            try {
                Socket client = server.accept();
                dispatchClient(client);
            } catch (IOException ex) {
                System.out.println("Error al establecer conexion con cliente: " + ex.getMessage());
            }
        }
    }

    public void stop() {
        try {
            server.close();
        } catch (IOException ex) {
            System.out.println(ex.getClass().getName() + " generated: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerDemo().run();
    }
}
