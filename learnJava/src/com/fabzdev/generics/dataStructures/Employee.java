
package com.fabzdev.generics.dataStructures;

/**
 *
 * @author fabio
 */
public class Employee {
    private String name;
    private String adress;
    private boolean gender;
    private double salary;
    
    public void setName(String name){
     this.name = name;   
    }
    
    public String getName(){
        return name;
    }
    
    public void printSalary(){
        System.out.println(salary);
    }
}
