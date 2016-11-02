package com.theironyard;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static final String PEOPLE = "people.txt";

    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<Person>> pHash = new HashMap<>();
        ArrayList<Person> p = readFile();
        sortPeople(pHash);
        addToHash(p, pHash);
        writeJson(pHash);
        System.out.println(pHash);
    }
    public static ArrayList<Person> readFile() throws FileNotFoundException {
        ArrayList<Person> p = new ArrayList<>();
        File file = new File(PEOPLE);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] sep = line.split(",");
            Person person = new Person(Integer.valueOf(sep[0]),sep[1],sep[2],sep[3],sep[4],sep[5]);
            p.add(person);
        }
        return p;
    }
    public static void writeJson(HashMap<String, ArrayList<Person>> pHash) throws IOException {
        File pJson = new File("people.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(pHash);
        FileWriter writeJson = new FileWriter(pJson);
        writeJson.append(json);
        writeJson.close();
    }
    public static void addToHash(ArrayList<Person> p, HashMap<String, ArrayList<Person>> pHash) {
        ArrayList<Person> peopleByCountry;
        for (Person person : p) {
            String country = person.getCountry();
            peopleByCountry = pHash.get(country);
            if (peopleByCountry == null) {
                peopleByCountry = new ArrayList<>();
            }
            peopleByCountry.add(person);
            pHash.put(country,peopleByCountry);
        }
    }
    public static void sortPeople(HashMap<String, ArrayList<Person>> pHash) {
        for (String country : pHash.keySet()) {
            ArrayList<Person> pArray = pHash.get(country);
            //Collections.sort(pArray);
        }
    }
}