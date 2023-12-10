/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.fabzdev.enums;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author fabio
 */
public enum JPanelEnums {
    VGA(860, 480),
    FULLHD(1080, 720),
    DOSK(2160, 1440);

    private final int width;
    private final int height;

    private JPanelEnums(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Dimension getResolution() {
        return new Dimension(width, height);
    }
    
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setMinimumSize(JPanelEnums.VGA.getResolution());
        frame.setVisible(true);
    }
}
