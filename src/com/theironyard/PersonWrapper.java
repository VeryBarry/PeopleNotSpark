package com.theironyard;

import java.util.ArrayList;

/**
 * Created by VeryBarry on 11/2/16.
 */
public class PersonWrapper {
    public ArrayList<Person> people;

    public PersonWrapper() {
    }
    public PersonWrapper(ArrayList<Person> people) {
        this.people = people;
    }
    public ArrayList<Person> getPeople() {
        return people;
    }
    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}