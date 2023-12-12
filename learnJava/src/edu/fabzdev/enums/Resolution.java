/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.fabzdev.enums;

/**
 *
 * @author fabio
 */
public enum Resolution {
    LOW(1024),
    MID(4096),
    HIGH(16384);

    private int maxRes;

    public int getMaxRes() {
        return maxRes;
    }
    
    private Resolution(int res) {
        this.maxRes = res;
    }
}
