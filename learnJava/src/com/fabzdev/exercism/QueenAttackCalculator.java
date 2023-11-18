/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class QueenAttackCalculator {

    private int table[][];
    private boolean canAttack;

    private static class Queen {
        private int posX;
        private int posY;

        public Queen(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }
    }

    public QueenAttackCalculator(Queen q1, Queen q2) throws Exception {
        if(q1 == null || q2 == null)
            throw new Exception();
        
        int q1x = q1.getPosX();
        int q1y = q1.getPosY();
        table = new int[8][8];

        while (q1x > 0 && q1y > 0) {
            q1x -= 1;
            q1y -= 1;
        }
        while (q1x < 8 && q1y < 8) {
            table[q1x][q1y] = 1;
            q1x += 1;
            q1y += 1;
        }

        q1x = q1.getPosX();
        q1y = q1.getPosY();
        while (q1x > 0 && q1y < 7) {
            q1x -= 1;
            q1y += 1;
        }
        while (q1x < 8 && q1y >= 0) {
            table[q1x][q1y] = 1;
            q1x += 1;
            q1y -= 1;
        }

        if (q1.getPosX() == q2.getPosX()) {
            canAttack = true;
        } else if (q1.getPosY() == q2.getPosY()) {
            canAttack = true;
        } else if (table[q2.getPosX()][q2.getPosY()] == 1) {
            canAttack = true;
        }
    }

    public boolean canQueensAttackOneAnother() {
        return canAttack;
    }

    public static void main(String[] args) {
        QueenAttackCalculator eq;
        try {
            eq = new QueenAttackCalculator(null, new Queen(5,6));
            System.out.println(eq.canQueensAttackOneAnother());
        } catch (Exception ex) {
            System.out.println("Null argument provided. " + ex.getMessage());
        }
    }
}
