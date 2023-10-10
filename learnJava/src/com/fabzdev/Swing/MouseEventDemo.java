/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.Swing;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class MouseEventDemo extends JFrame implements MouseListener {

    private MouseEventDemo(String title) {
        super.setTitle(title);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.printf("Clicked (%d, %d)\n", e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MouseEventDemo frame = new MouseEventDemo("Mouse Event Demo");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400, 500));
                frame.addMouseListener(frame);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

}
