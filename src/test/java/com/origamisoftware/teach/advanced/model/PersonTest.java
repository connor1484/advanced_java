package com.origamisoftware.teach.advanced.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A Unit test for the Person class
 */
public class PersonTest {

    public static final String firstName = "John";
    public static final String lastName = "Smith";

    /**
     * Create person
     * @return a Person object that uses static constants for data.
     */

    public static Person createPerson() {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }

    /**
     * Tests getter and setter methods of person
     * @return a Person object that uses static constants for data.
     */
    @Test
    public void testPersonGettersAndSetters() {
        Person person = createPerson();
        int id = 100;
        person.setId(id);
        assertEquals("First Name matches", firstName, person.getFirstName());
        assertEquals("Last Name matches", lastName, person.getLastName());
        assertEquals("id matches", id, person.getId());

    }

}
