package com.theironyard;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static final String PEOPLE = "people.txt";

    public static void main(String[] args) {
    }


    public static ArrayList<Person> readFile() throws FileNotFoundException {
        ArrayList<Person> people = new ArrayList<>();
        File file = new File(PEOPLE);
        Scanner fileScanner = null;
        fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");
            Person person = new Person(Integer.valueOf(columns[0]),columns[1],columns[2],columns[3],columns[4],columns[5]);
            people.add(person);
        }
        return people;
    }
    public static void writeJson(HashMap<String, ArrayList<Person>> peopleMap) throws IOException {
        File peopleJson = new File("people.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(peopleMap);
        FileWriter writeJson = new FileWriter(peopleJson);
        writeJson.append(json);
        writeJson.close();
    }
}
