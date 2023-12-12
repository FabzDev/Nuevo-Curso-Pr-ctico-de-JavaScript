/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.swing.awt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BallAnimation extends JPanel {

    int x;
    int y;
    int incrX;
    int incrY;
    int size;
    public javax.swing.Timer timer;

    public BallAnimation() {
        super();
        x = 0;
        y = 0;
        incrX = 2;
        incrY = 2;
        size = 10;

        timer = new javax.swing.Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.black);
        g.setColor(Color.yellow);
        if (x >= 0 && (x + size) < getWidth()) {
            x += incrX;
        } else {
            incrX *= -1;
            x += incrX;
        }

        if (y >= 0 && (y + size) < getHeight()) {
            y += incrY;
        } else {
            incrY *= -1;
            y += incrY;
        }
        
        g.fillRect(x, y, size, size);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                BallAnimation panel = new BallAnimation();
                frame.setContentPane(panel);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        panel.timer.stop();
                    }

                });
                frame.setMinimumSize(new Dimension(500, 400));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }
}
