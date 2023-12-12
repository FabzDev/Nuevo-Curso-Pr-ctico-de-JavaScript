/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.enums;

/**
 *
 * @author fabio
 */
public class DiasSemanaDemo {
    public static void main(String[] args) {
        DiasSemana hoy = DiasSemana.MIERCOLES;
        
        DiasSemana.MIERCOLES.dayName = "Wednesday";
        
        System.out.println("Hoy es: " + hoy.dayName);
    }
}
