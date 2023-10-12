/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.Swing;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class CreateNewFrameDemo extends JFrame {

    public static CreateNewFrameDemo getInstance() {
        CreateNewFrameDemo frame = new CreateNewFrameDemo();
        frame.setTitle("Correct Frame Creation");
        frame.setDefaultCloseOperation(2);
        frame.setMinimumSize(new Dimension(300, 400));
        frame.setLocationRelativeTo(null);
        return frame;
    }

//    private CreateNewFrameDemo() {
//        super("Correct Frame Creation");
//        setDefaultCloseOperation(2);
//        setMinimumSize(new Dimension(400, 500));
//        setLocationRelativeTo(null);
//    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateNewFrameDemo frame = CreateNewFrameDemo.getInstance();
                frame.setVisible(true);

            }
        });
    }
}
