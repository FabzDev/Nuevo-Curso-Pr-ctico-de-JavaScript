/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class Queen {
private int posX;
        private int posY;

        public Queen(int posX, int posY) throws IllegalArgumentException{
            if (posX >= 0 && posX <=7){
                this.posX = posX;
                }
            if (posY >= 0 && posY <=7){
                this.posY = posY;
                }
            if(!(posX >= 0)){
                throw new IllegalArgumentException("Queen position must have positive row.");
            }
            if(!(posX <= 7)){
                throw new IllegalArgumentException("Queen position must have row <= 7.");
            }
            if(!(posY >= 0)){
                throw new IllegalArgumentException("Queen position must have positive column.");
            }
            if(!(posY <= 7)){
                throw new IllegalArgumentException("Queen position must have column <= 7.");
            }
            
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }
    

}
