/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class CarsAssemble {
    public double productionRatePerHour(int speed) {
        if(speed==0){
            return 0;
        }else if(speed>0 && speed<=4){
            return 221 * speed;
        }else if(speed>4 && speed<=8){
            return 221 * speed * 0.9;
        }else if(speed==9){
            return 221 * speed * 0.8;
        }else if(speed==10){
            return 221 * speed * 0.77;
        }else {
            return -1;
        }
    }

    public int workingItemsPerMinute(int speed) {
        double itemsPerMin = productionRatePerHour(speed);
        return (int)(itemsPerMin / 60);
    }
    
    public static void main(String[] args) {
        System.out.println(new CarsAssemble().productionRatePerHour(6));
        System.out.println(new CarsAssemble().workingItemsPerMinute(6));
    }
}
