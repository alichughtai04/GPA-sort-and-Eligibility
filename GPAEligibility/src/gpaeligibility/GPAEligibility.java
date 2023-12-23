/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gpaeligibility;
/**
 *
 * @author aachu
 */
import java.io.BufferedReader;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GPAEligibility {
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Professor> professors = new ArrayList<>();
        
        String line;
        String path = "C:\\Users\\aachu\\Documents\\NetBeansProjects\\GPAEligibility\\src\\gpaeligibility\\inputData.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("student") || data[0].equals("graduatestudent")) {
                    // Parsing student data
                    String studentType = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    int studentId = Integer.parseInt(data[3]);
                    String major = data[4];
                    double gpa = Double.parseDouble(data[5]);
                    int credits = Integer.parseInt(data[6]);

                    // Creating and adding Student object to the list
                    students.add(new Student(firstName, lastName, studentId, major, gpa, credits, studentType));
                }
                if (data[0].equals("professor")) {
                    String department = data[4];
                    double salary = Double.parseDouble(data[5]);
                    String firstName = data[1];
                    String lastName = data[2];
                    int id = Integer.parseInt(data[3]); 
                    
                    professors.add(new Professor(department, salary, firstName, lastName, id));
                }
            }
            // Sorting the list of students based on GPA
            Collections.sort(students);
            Collections.sort(professors);

            // Printing the sorted list of students
            System.out.println("Here is our sorted list of Students: ");
            System.out.println("Undergraduate Students: ");
            System.out.println();
            for (Student student : students) {
                if (student.getStudentType().equals("student")) {
                    System.out.println(student.getStudentType() + student);
                }
            }
            System.out.println();
            System.out.println("Graduate Students: ");
            System.out.println();
            for (Student gradStudent : students) {
                if (gradStudent.getStudentType().equals("graduatestudent")) {
                    System.out.println(gradStudent.getStudentType() + gradStudent);
                }
            }
            System.out.println();
            System.out.println("Here is our sorted list of Professors:");
            System.out.println();
            for (Professor professor : professors) {
                System.out.println(professor);
            }
        } 
        FileOutputStream fs = new FileOutputStream("C:\\Users\\aachu\\Documents\\NetBeansProjects\\GPAEligibility\\src\\eligibleScholars.txt");
        PrintWriter outFS = new PrintWriter(fs);
    try {
        //PrintWriter outFS = new PrintWriter(fs);
        outFS.println("Our top candidates for this Scholarship are: ");
        outFS.println("---------------------");
        for (int i = 0; i < students.size(); i++) {
                // Print relevant student information
                if (students.get(i).getStudentType().equals("student") && students.get(i).getGPA() >= 3.5) {
                    outFS.println(students.get(i));
                    outFS.println();
                }
        }
        outFS.println("---------------------");
        outFS.println("Our middle candidates for this Scholarship are: ");
        for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentType().equals("student") && (students.get(i).getGPA() <= 3.4 && students.get(i).getGPA() >= 3.2)) {
                    outFS.println(students.get(i));
                    outFS.println();
                    }
                
        }
        outFS.println("---------------------");
        outFS.println("Our ineligible candidates for this Scholarship are: ");
        for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getGPA() < 3.2) {
                    outFS.println(students.get(i));
                    outFS.println();
                }       
        }
        outFS.println("---------------------");     
        outFS.close();
        fs.close();
        // writes list of tenured professors based on salary
        String path2 = "C:\\Users\\aachu\\Documents\\NetBeansProjects\\GPAEligibility\\src\\tenuredProffesors.txt";
        FileOutputStream profFS = new FileOutputStream(path2);
        PrintWriter outProfFS = new PrintWriter(profFS);
        
        outProfFS.println("Our most tenured and highest paying Professors are: ");
        for (int i = 0; i < professors.size(); i++) {
            if (professors.get(i).getSalary() >= 85000) {
                outProfFS.println(professors.get(i));
                outProfFS.println();
            }
        }
        outProfFS.println("---------------------");
        outProfFS.println("Our recently hired Professors are: ");
        for (int i = 0; i < professors.size(); i++) {
            if (professors.get(i).getSalary() < 85000) {
                outProfFS.println(professors.get(i));
                outProfFS.println();
            }
        }
        outProfFS.println("---------------------");
        outProfFS.close();
        profFS.close();
        
        String path3 = "C:\\Users\\aachu\\Documents\\NetBeansProjects\\GPAEligibility\\src\\gradList.txt";
        FileOutputStream gradFS = new FileOutputStream(path3);
        PrintWriter outGradFS = new PrintWriter(gradFS);
        
        outGradFS.println("List of current respective graduate students: ");
        outGradFS.println();
        for (Student gradStudent : students) {
                if (gradStudent.getStudentType().equals("graduatestudent")) {
                    outGradFS.println(gradStudent.getStudentType() + gradStudent);
                    outGradFS.println();
                }
            }
        outGradFS.close(); 
        gradFS.close();
        //outGradFS.close();  
    }   
    catch(FileNotFoundException ex) {
        System.out.println("Caught FileNotFoundException for inputdata.txt. Try again making sure the file name and path are correct.");
    }
    catch (IOException ex){
        System.out.println("Caught IOException when closing output stream. Try Again.");
    }
        
    }    
}
