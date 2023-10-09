
package com.fabzdev.Swing;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author fabio
 */
public class JFrameDemo1 {
        public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
