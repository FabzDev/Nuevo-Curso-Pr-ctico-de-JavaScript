package edu.fabzdev.dataStructures;

/**
 *
 * @author fabio
 */
public class EmployeeDemo {

    public static void main(String[] args) {
        Employee employee[] = new Employee[100];

//        Employee e = new Employee();
//        initemployee(e);
//        printEmployee(e);
//        for(int i = 0; i < employee.length; i++){
//           if(emp.salary > 10000)
//               printEmployee(e);
//        }
        
        Employee sup = new Employee();
        Employee em = new Employee();
        em.setSupervisor(sup);
        
        for(Employee emp : employee){
            if(emp.salary > 10000)
                emp.printSalary();
        }
        
    }

}
