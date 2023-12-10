/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class ElonsToyCar {

    private int distance = 0;
    private int battery = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distance);
    }

    public String batteryDisplay() {
        if(battery > 0)
            return String.format("Battery at %d%%", battery);
        else
            return "Battery empty";
    }

    public void drive() {
        if (battery > 0) {
            this.distance += 20;
            this.battery -= 1;
        }else{
            batteryDisplay();
        }
    }
    
    public static void main(String[] args) {
        ElonsToyCar etc = new ElonsToyCar();
        System.out.println(etc.batteryDisplay());
    }
}
