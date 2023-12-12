/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.swing;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author fabio
 */
public class ShowMessageDialogDemo {
    public static void main(String[] args) {
        ShowMessageDialogDemo smd = new ShowMessageDialogDemo();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                JFrame frame = new JFrame("ShowMessage");
//                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                frame.setMinimumSize(new Dimension(400, 500));
//                frame.setVisible(true);
                JOptionPane.showMessageDialog(null, "No lo entenderias");
                
            }
        });
    }
}
