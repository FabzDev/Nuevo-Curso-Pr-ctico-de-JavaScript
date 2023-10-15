/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.Swing.awt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BallAnimation1 extends JPanel {

    private int x;
    private int y;
    private int incX;
    private int incY;
    private int size;
    private javax.swing.Timer timer;

    public BallAnimation1() {
        super();
        x = 0;
        y = 0;
        incX = 2;
        incY = 2;
        size = 10;

        timer = new javax.swing.Timer(1000/120, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
            }
        });
        timer.start();
    }

    private void animate() {
        Rectangle border = new Rectangle(new Dimension(getWidth(), getHeight()));
        x += incX;
        if (x + size >= border.width) {
            x = border.width - size;
            incX *= -1;
        } else if (x <= 0){
            x = 0;
            incX *= -1;
        }
        y += incY;
        if (y + size >= border.height) {
            y = border.height - size;
            incY *= -1;
        } else if (y <= 0){
            y = 0;
            incY *= -1;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.black);
        g.setColor(Color.yellow);
        g.fillRect(x, y, size, size);
    }

    private void stopTimer() {
        timer.stop();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                BallAnimation1 panel = new BallAnimation1();
                frame.setContentPane(panel);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        panel.stopTimer();
                    }
                });
                frame.setMinimumSize(new Dimension(500, 400));
                frame.setLocationRelativeTo(null);
                //RepaintManager.currentManager(frame).setDoubleBufferingEnable(false);
                frame.setVisible(true);
            }
        });
    }
}
