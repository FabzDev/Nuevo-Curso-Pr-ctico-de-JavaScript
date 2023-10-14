/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.Swing.awt;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class ImageDemo extends JPanel {

    private BufferedImage image;

    public ImageDemo(JFrame owner) {
        super();
        new Thread(new Runnable() {
            @Override
            public void run() {
                readImage();
                if (image != null) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            Dimension size = new Dimension(image.getWidth(), image.getHeight());
                            setMinimumSize(size);
                            setPreferredSize(size);
                            owner.pack();
                            owner.setLocationRelativeTo(null);
                            repaint();
                        }
                    });
                }
            }
        }).start();

        Dimension size = new Dimension(400, 200);
        setMinimumSize(size);
        setPreferredSize(size);
    }
    
    private void printText(Graphics g){
        String str = "Loading";
        g.setFont(g.getFont().deriveFont(36f));
        FontMetrics fm = g.getFontMetrics();
        g.drawString(str, (getWidth()/2 - fm.stringWidth(str)/2), getHeight()/2 + fm.getAscent() - fm.getHeight()/2);
            
    }

    private void readImage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        try (InputStream is = getClass().getResourceAsStream("/com/fabzdev/swing/awt/palestine.jpg")) {
            if (is != null) {
                image = ImageIO.read(is);
            }
        } catch (Exception error) {
            System.out.println("Hey: " + error);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }else {
            printText(g);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
//                frame.setMinimumSize(new Dimension(500, 500));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setContentPane(new ImageDemo(frame));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
