/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.swing.awt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class DrawingDemo1 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

//        for (int i = 0; i < 16; i++) {
//            g2d.setColor(new Color(0, (256/16 * i), 0));
//            g2d.fillRect(i*getHeight()/32, i*getWidth()/32, (getWidth() - 1 - i*getWidth()/16), (getHeight() - 1 - i*getHeight()/16));
//        }
        int x;
        int y;
        int width = getWidth();
        int height = getHeight();
        int count=0;
        int step =16;
        while (width != 0 && height != 0 && count < 16) {
            x = count*step;
            y = count*step;
            
            g2d.setColor(new Color(0, ((256/16) * count), 0));
            g2d.fillRect(x, y, width, height);
            width = width - 2*step;
            height = height - 2*step;
            count++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setLocationRelativeTo(null);
                frame.setMinimumSize(new Dimension(500, 400));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);

                GridBagLayout gbLayout = new GridBagLayout();
                JPanel jpanel = new DrawingDemo1();
                jpanel.setBackground(Color.black);
                frame.add(jpanel);
                jpanel.setLayout(gbLayout);

            }
        });
    }
}
