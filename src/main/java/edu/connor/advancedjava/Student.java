/*
 * Connor Ryan
 * Advanced Java Programming
 * Assignment 1
 *
 * Student class that creates a new Person object as a student
 */

package edu.connor.advancedjava;
import java.time.LocalDate;
import java.time.Year;

/**
 * Represents a student with a name and date of birth.
 */
public class Student {

    /**
     * Main method to create a Person object that represents a student.
     *
     * @param args
     */
    public static void main(String[] args) {

        String name = "Connor";
        LocalDate dateOfBirth = LocalDate.of(1980, 1, 20);  //date of birth of student
        Person student = new Person(name, dateOfBirth);     //creates person object for student
        int age = student.getAge();                         //age of the student
        System.out.println("Age of " + name + " is " + age);
        student.sayHi();                                    //Prints Hello to student
    }

}