/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gpaeligibility;

/**
 *
 * @author aachu
 */
public class GradStudent extends Student {

    public GradStudent(String firstName, String lastName, int id, String major, double gpa, int credits, String studentType) {
        super(firstName, lastName, id, major, gpa, credits, studentType);
    }

    
    
    

    @Override
    public String toString() {
        return "GradStudent{" + '}';
    }
    
    
}
