/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int n : birdsPerDay){
            if(sb.length()>1)
                sb.append(", " + n);
            else
                sb.append(n);
        }
        sb.append("]");
        System.out.println(sb.toString());
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length-1] = this.getToday()+ 1;
    }

    public boolean hasDayWithoutBirds() {
        for(int day : birdsPerDay){
            if(day == 0)
                return true;
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int newNumberOfDays = numberOfDays>birdsPerDay.length?birdsPerDay.length:numberOfDays;
        int count = 0;
        for(int n = 0; n<newNumberOfDays;n++){
            count += birdsPerDay[n];
        }
        return count;
    }

    public int getBusyDays() {
        int count = 0;
        for(int day : birdsPerDay){
            if(day >= 5){
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        BirdWatcher bw = new BirdWatcher(new int[]{ 2, 5, 0, 7, 4, 1 });
        bw.getLastWeek();
        bw.incrementTodaysCount();
        System.out.println(bw.getCountForFirstDays(10));
    }
}
