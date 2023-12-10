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
public class IPAddressAll {

    public static void main(String[] args) throws Exception {
        InetAddress host = InetAddress.getLocalHost();
        InetAddress[] ips = InetAddress.getAllByName(host.getCanonicalHostName());
        if (ips != null) {
        System.out.println("Ip addresses for this PC: ");
            for (InetAddress adrs : ips) {
                System.out.println("    " + adrs);
            }
        }
    }
}
