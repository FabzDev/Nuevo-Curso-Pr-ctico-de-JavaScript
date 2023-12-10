/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.swing;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class InputDialogDemo {

    public static void main(String[] args) {
        InputDialogDemo smd = new InputDialogDemo();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                JFrame frame = new JFrame("ShowMessage");
//                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                frame.setMinimumSize(new Dimension(400, 500));
//                frame.setVisible(true);
                String name = JOptionPane.showInputDialog(null, "Cual es tu nombre?");
                if (name != null) {
                    JOptionPane.showMessageDialog(null, "|Hola " + name + "|");
                }
            }
        });
    }
}
