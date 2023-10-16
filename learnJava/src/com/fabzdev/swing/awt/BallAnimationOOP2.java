/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.swing.awt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BallAnimationOOP2 extends JPanel {

    private class Ball {

        private int x;
        private int y;
        private int incX;
        private int incY;
        private int size;
        private Color color;

        public Ball(int x, int y, int size, int incX, int incY, Color color) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.incX = incX;
            this.incY = incY;
            this.color = color;
        }

        private void animate() {
            Rectangle border = new Rectangle(new Dimension(getWidth(), getHeight()));
            x += incX;
            if (x + size >= border.width) {
                x = border.width - size;
                incX *= -1;
            } else if (x <= 0) {
                x = 0;
                incX *= -1;
            }
            y += incY;
            if (y + size >= border.height) {
                y = border.height - size;
                incY *= -1;
            } else if (y <= 0) {
                y = 0;
                incY *= -1;
            }
        }

        private void paint(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.fillOval(x, y, size, size);
        }
    }

    //BallAnimation continue:
    private javax.swing.Timer timer;
    private Ball[] balls = new Ball[100];

    public BallAnimationOOP2() {
        super();
        setBackground(Color.black);
        createBalls();
        timer = new javax.swing.Timer(1000 / 120, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Ball ball : balls) {
                    ball.animate();
                }
                repaint();

            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Ball ball : balls) {
            ball.paint(g2d);
        }
    }

    private void stopTimer() {
        timer.stop();
    }

    private int random(double max) {
        return (int) (max * Math.random());
    }

    private void createBalls() {
        for (int n = 0; n < balls.length; n++) {
            balls[n] = new Ball(random(500), random(400), 10 + random(20), 1 + random(10),
                    1 + random(10), new Color((50 + random(205)), (50 + random(205)), (50 + random(205))));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                BallAnimationOOP2 panel = new BallAnimationOOP2();
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
