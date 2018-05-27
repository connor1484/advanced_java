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


public class Student {

    public static void main(String[] args) {

        String name = "Connor";                             //name of student
        LocalDate dateOfBirth = LocalDate.of(1980, 1, 20);  //date of birth of student
        Person student = new Person(name, dateOfBirth);     //creates person object for student
        int age = student.getAge();                         //age of the student
        System.out.println("Age of " + name + " is " + age);
        student.sayHi();
    }

}