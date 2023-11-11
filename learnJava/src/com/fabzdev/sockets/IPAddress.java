/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.sockets;

import java.net.InetAddress;

/**
 *
 * @author fabio
 */
public class IPAddress {
    public static void main(String[] args) throws Exception{
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("host name: " + ip.getHostName());
        System.out.println("ip address: " + ip.getHostAddress());

    }
}
