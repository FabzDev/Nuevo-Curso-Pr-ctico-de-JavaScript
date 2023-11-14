/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.database;

/**
 *
 * @author fabio
 */
public class AnnalynsInfiltration {
    
    public static boolean canFastAttack(boolean knightIsAwake) {
        if(knightIsAwake)
            return false;
        else 
            return true;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        if(knightIsAwake || archerIsAwake || prisonerIsAwake)
            return true;
        else
            return false;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        if(archerIsAwake == false && prisonerIsAwake)
            return true;
        else
            return false;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        if((petDogIsPresent && !archerIsAwake && prisonerIsAwake) || (prisonerIsAwake && !knightIsAwake && !archerIsAwake))
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        
        System.out.println(AnnalynsInfiltration.canFastAttack(true));
        System.out.println(AnnalynsInfiltration.canSpy(false, true, false));
        System.out.println(AnnalynsInfiltration.canSignalPrisoner(false, true));
        System.out.println(AnnalynsInfiltration.canFreePrisoner(false, false, false, true));
    }
}
