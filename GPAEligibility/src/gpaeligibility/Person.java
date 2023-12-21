/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gpaeligibility;

/**
 *
 * @author aachu
 */
public abstract class Person {
    
    private String firstName;
    private String lastName;
    private int id;

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.getId() == ((Person) other).getId();
    }
    
}
