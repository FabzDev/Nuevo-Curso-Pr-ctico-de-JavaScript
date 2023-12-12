/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.swing;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class MouseAdapterDemo extends JFrame {

    private MouseAdapterDemo(String title) {
        super.setTitle(title);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MouseAdapterDemo frame = new MouseAdapterDemo("Mouse Event Demo");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400, 500));
                frame.addMouseListener(new MouseAdapter(){

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.printf("Click (%d,%d)\n",e.getX(), e.getY());
                    }

                });
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

}
