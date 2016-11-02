import com.theironyard.Main;
import com.theironyard.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by VeryBarry on 11/2/16.
 */
public class PeopleTest {
    @Test
    public void testReadFile() throws FileNotFoundException {
        ArrayList<Person> p = Main.readFile();
        assertTrue(!p.isEmpty());
        assertTrue(p.get(0).getClass().equals(Person.class));
    }
    @Test
    public void testAddToHash() throws FileNotFoundException {
        HashMap<String, ArrayList<Person>> pHash = new HashMap<>();
        ArrayList<Person> people = Main.readFile();
        Main.addToHash(people,pHash);
        assertTrue(!pHash.isEmpty());
    }
    @Test
    public void testWriteJson() throws IOException {
        HashMap<String, ArrayList<Person>> pHash = new HashMap<>();
        ArrayList<Person> p = Main.readFile();
        Main.addToHash(p, pHash);
        File file = new File("people.json");
        Main.writeJson(pHash);
        assertTrue(file.exists());
    }
    @Test
    public void testSortPeople() throws FileNotFoundException {
        HashMap<String, ArrayList<Person>> pHash = new HashMap<>();
        ArrayList<Person> p = Main.readFile();
        Main.addToHash(p, pHash);
        Main.sortPeople(pHash);
        assertTrue(pHash.get("France").get(1).lastName.compareTo(pHash.get("France").get(1).lastName) < 0);
    }
}
