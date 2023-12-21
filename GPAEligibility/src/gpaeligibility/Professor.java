/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gpaeligibility;

/**
 *
 * @author aachu
 */

public class Professor extends Person implements Comparable<Professor> {
    
    private String department;
    private double salary;
    
/**
 * 
 * @param department
 * @param salary
 * @param firstName
 * @param lastName
 * @param id 
 */
    public Professor(String department, double salary, String firstName, String lastName, int id) {
        super(firstName, lastName, id);
        this.department = department;
        this.salary = salary;
        
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Professor - " + this.getFirstName() + " " + this.getLastName() + " ID: " + this.getId() + " | " + department + " | Salary: $" + salary;
    }

    @Override
    public int compareTo(Professor o) {
        double oSalary = o.getSalary();
        double nSalary = this.salary;
        if (oSalary > nSalary) {
            return 1;
        }
        if (oSalary < nSalary) {
            return -1;
        }
        else {
            return 0;
        }
    }
    }
