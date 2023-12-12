/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class QueenAttackCalculator {

    private int table[][];
    private boolean canAttack;

    QueenAttackCalculator(Queen queen1, Queen queen2) throws IllegalArgumentException {
        if (queen1 == null || queen2 == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (queen1.getPosX() == queen2.getPosX() && queen1.getPosY() == queen2.getPosY()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        int q1x = queen1.getPosX();
        int q1y = queen1.getPosY();
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

        q1x = queen1.getPosX();
        q1y = queen1.getPosY();
        while (q1x > 0 && q1y < 7) {
            q1x -= 1;
            q1y += 1;
        }
        while (q1x < 8 && q1y >= 0) {
            table[q1x][q1y] = 1;
            q1x += 1;
            q1y -= 1;
        }

        if (queen1.getPosX() == queen2.getPosX()) {
            canAttack = true;
        } else if (queen1.getPosY() == queen2.getPosY()) {
            canAttack = true;
        } else if (table[queen2.getPosX()][queen2.getPosY()] == 1) {
            canAttack = true;
        }
    }

    boolean canQueensAttackOneAnother() {
        return canAttack;
    }

    public static void main(String[] args) {
        try {
            QueenAttackCalculator eq = new QueenAttackCalculator(new Queen(5, 3), new Queen(5, 6));
            System.out.println(eq.canQueensAttackOneAnother());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
