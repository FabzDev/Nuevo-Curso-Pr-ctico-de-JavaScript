/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.enums;

/**
 *
 * @author fabio
 */
public class TestResolution {
    private Resolution r;
    
    public int getSpeedPro(){
        return 1500;
    }
    
    public void test1(){
        int speedPro = getSpeedPro();
        if(speedPro > 1000){
            r = r.HIGH;
        } else {
            r = r.LOW;
        }
        
//        System.out.println("La resolución ha sido configurada en: " + r);
        System.out.println("La resolución ha sido configurada en: " + r.getMaxRes() + " pixeles");
    }
    
    public static void main(String[] args) {
        new TestResolution().test1();
    }
    
}
