/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.fabzdev.enums;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class EnumDetail1 {

    public static final int NONE = 0;
    public static final int WAITING = 1;
    public static final int RUNNING = 2;
    public static final int DONE = 3;
    public static final int ERROR = 4;
    public static final int BLUE = 5;
    public static final int RED = 6;
    public static final int GREEN = 7;
    

    public void setStatus(Status st) {
        System.out.println("El status actual es: " + st);
    }

    private static void test1() {
        JOptionPane.showMessageDialog(null, "Salute", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void test2(){
        Resolution res = Resolution.MID;
        if(res == Resolution.HIGH){
            Resolution.HIGH.getMaxRes();
            res.getMaxRes();
            }
        
    }

    public static void main(String[] args) {
//            EnumDetail1.test1();
//        new EnumDetail1().setStatus(Status.DONE);
//        new EnumDetail1().test2();
        
    }

}
