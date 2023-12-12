/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.swing;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class JFrameDemo4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("FrameDemo4");
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosing(WindowEvent e) {
                        if(JOptionPane.showConfirmDialog(frame, "Finalizar aplicación?","Cerrar",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        System.out.println("Cerrando");    
                        frame.dispose();
                        }
                    }
                    
                });
                frame.setMinimumSize(new Dimension(400, 300));
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });

    }
}
