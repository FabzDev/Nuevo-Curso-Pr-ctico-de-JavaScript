/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class ExersismQueen {

    private int table[][];
    private boolean canAttack;

    private class Queen {

        private int posX;
        private int posY;

        public Queen(String posAbs) {
            char charX = posAbs.charAt(0);
            char charY = posAbs.charAt(1);

            setPosX(charX);
            setPosY(charY);
        }

        public void setPosX(char charX) {
            int n = (int) charX;
            posX = n - 97;
        }

        public void setPosY(char charY) {
            int n = (int) charY;
            posY = 8 - (n - 48);
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }
    }

    public void QueenAttackCalculator(Queen q1, Queen q2) {
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
        
        if(q1.getPosX() == q2.getPosX()){
            canAttack = true;
        } else if (q1.getPosY() == q2.getPosY()) {
            canAttack = true;
        } else if (table[q2.getPosX()][q2.getPosY()] == 1){
            canAttack = true;
        }
    }
    
    public boolean canQueensAttackOneAnother() {
        return canAttack;
    }

    public static void main(String[] args) {
        ExersismQueen eq = new ExersismQueen();
        Queen q1 = eq.new Queen("g2");
        Queen q2 = eq.new Queen("c5");
        eq.QueenAttackCalculator(q1, q2);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(eq.table[j][i] + " ");
            }
                System.out.println();
        }
        
        System.out.println("\nCan queens attack each other: " + eq.canQueensAttackOneAnother());
    }
}
