package edu.connor.advancedjava;

import java.time.LocalDate;
import java.time.Year;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Unit test for PersonTest Class
 */
public class PersonTest  {

    private Person student;         //student Person object
    private int age;                //age of Student
    private String name;            //name of Student

    /**
     * Create the Person object to test
     *
     * @param testName name of the test case
     */
    @Before
    public void setup() {
        // create a known state of the Person object(also known as a baseline)
        name = "Connor";
        LocalDate dateOfBirth = LocalDate.of(1980, 1, 20);
        student = new Person(name, dateOfBirth);
    }

    @Test
    public void testAge() {

        //testing result of expected age
        age = student.getAge();
        assertEquals(38, age);
    }

    @Test
    public void testName() {
        //testing result of name
        assertEquals(name, student.getName());
    }

    @Test
    public void testNegativeAge() {
        //testing result of negative test where age is incorrect
        age = student.getAge();
        assertFalse(age == 45);
    }

    @Test
    public void testNegativeName() {
        //test result of negative test where name is incorrect
        name = "Bill";
        assertFalse(student.getName() == name);
    }


}
