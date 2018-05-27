/*
 * Person class that will return the name and age of the person and also say Hello
 */

package edu.connor.advancedjava;
import java.time.LocalDate;
import java.time.Year;
import java.time.Period;

public class Person {

    private String name;                //name of the person
    private LocalDate dateOfBirth;      //date of birth of the person

    //Constructor that requires the name and date of birth to be passed in and assigns them to the class variables
    public Person(String name, LocalDate dateOfBirth) {

        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Calculates and returns the age of the Person
     *
     * @return age - age of the person
     */
    public int getAge() {

        LocalDate curDate = LocalDate.now();                    //current date
        //calculates the difference between the current date and the date of birth of the person
        return Period.between(dateOfBirth, curDate).getYears();
    }

    /**
     * Returns the name of the Person
     *
     * @return name - name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Says Hello to the person
     */
    public void sayHi() {

        System.out.println("Hello " + name);
    }


}