/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class Queen {

    private int posX;
    private int posY;

    public Queen(int posX, int posY) {
        if (posX >= 0) {
            this.posX = posX;
        }
        if (posY >= 0) {
            this.posY = posY;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}
