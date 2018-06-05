package edu.connor.advancedjava;
import java.time.LocalDate;
import java.time.Year;
import java.time.Period;

/**
 * Person class that will return the name and age of the person and also say Hello
 *
 */
public class Person {

    private String name;
    private LocalDate dateOfBirth;

    /**
     * Creates a new Person with the given and given date of birth
     * @param name
     * @param dateOfBirth
     */
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
     *
     */
    public void sayHi() {

        System.out.println("Hello " + name);
    }


}