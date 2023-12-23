/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gpaeligibility;

/**
 *
 * @author aachu
 */
public class Student extends Person implements Comparable<Student> {
    
    private String major;
    private double gpa;
    private int credits;
    private String studentType;

    public Student(String firstName, String lastName, int id, String major, double gpa, int credits, String studentType) {
        super(firstName, lastName, id);
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
        this.studentType = studentType;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return " - " + "Name: " + this.getFirstName() + " " + this.getLastName() + " | " + this.major + " | GPA: " + this.gpa + " | Credits earned: " + this.credits ;
    }
    public String getStudentType() {
        return this.studentType;
    }
    
    @Override
    public int compareTo(Student o) {
        double oGPA = o.getGPA();
        double sGPA = this.gpa;        
        if(sGPA < oGPA){
            return 1;
        }
        else if(sGPA > oGPA){
            return -1;
        }
        else return 0;
    }
}

