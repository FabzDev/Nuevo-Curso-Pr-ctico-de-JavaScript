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

public class BallAnimationOOPFigure extends JPanel {

    private class Ball {
        int x;
        int y;
        int incX;
        int incY;
        int size;
        Color color;

        public Ball(int x, int y, int size, int incX, int incY, Color color) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.incX = incX;
            this.incY = incY;
            this.color = color;
        }

        public void animate() {
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

        public void paint(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.fillOval(x, y, size, size);
        }
    }

    private class SolidRect extends Ball {
        public SolidRect(int x, int y, int size, int incX, int incY, Color color) {
            super(x, y, size, incX, incY, color);
        }
        @Override
        public void paint(Graphics2D g2d) {
            g2d.setColor(super.color);
            g2d.fillRect(super.x, super.y, super.size, super.size);
        }
    }

    private class FrameRect extends Ball {
        public FrameRect(int x, int y, int size, int incX, int incY, Color color) {
            super(x, y, size, incX, incY, color);
        }
        @Override
        public void paint(Graphics2D g2d) {
            g2d.setColor(super.color);
            g2d.drawRect(super.x, super.y, super.size, super.size);
        }
    }

    private class Triangle extends Ball {
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        public Triangle(int x, int y, int size, int incX, int incY, Color color) {
            super(x, y, size, incX, incY, color);
        }
        
        @Override
        public void animate() {
            super.animate();
            xPoints[0] = x + size / 2;
            xPoints[1] = x + size;
            xPoints[2] = x;

            yPoints[0] = y;
            yPoints[1] = y + size;
            yPoints[2] = y + size;
        }
        
        @Override
        public void paint(Graphics2D g2d) {
            g2d.setColor(super.color);
            g2d.drawPolygon(xPoints, yPoints, 3);
        }
    }

    //BallAnimation continue:
    private javax.swing.Timer timer;
    private Ball[] balls = new Ball[1024];

    public BallAnimationOOPFigure() {
        super();
        setBackground(Color.black);
        createFigures();
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

    private void createFigures() {

        for (int n = 0; n < balls.length; n++) {
            int size = 10 + random(20);
            int x = random(500) - size;
            int y = random(400) - size;
            int incX = 1 + random(10);
            int incY = 1 + random(10);
            Color color = new Color((50 + random(205)), (50 + random(205)), (50 + random(205)));
            int figure = random(4);

            switch (figure) {
                case 0:
                    balls[n] = new Ball(x, y, size, incX, incY, color);
                    break;
                case 1:
                    balls[n] = new SolidRect(x, y, size, incX, incY, color);
                    break;
                case 2:
                    balls[n] = new FrameRect(x, y, size, incX, incY, color);
                    break;
                case 3:
                    balls[n] = new Triangle(x, y, size, incX, incY, color);
                    break;
            }

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                BallAnimationOOPFigure panel = new BallAnimationOOPFigure();
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
