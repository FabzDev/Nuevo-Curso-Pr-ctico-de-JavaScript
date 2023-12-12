
package edu.fabzdev.dataStructures;

/**
 *
 * @author fabio
 */
public class Employee {
    public String name;
    public String adress;
    public boolean gender;
    public double salary;
    public Employee supervisor;
    
    public void setName(String name){
     this.name = name;   
    }
    
    public void setSupervisor(Employee supervisor){
        this.supervisor = supervisor;
    }
    
    public Employee getSupervisor(){
        return this.supervisor;
    }
    
    public String getName(){
        return name;
    }
    
    public void printSalary(){
        System.out.println(salary);
    }
}
