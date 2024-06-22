import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DataBaseReadDataTest {

    private BufferedReader reader;
    HashMap <String,Employee> expectedHashMap;
    DataBase dataBase;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Manager.employees.clear();
        dataBase = null;
    }

    @Test
    public void readDataPositive() { // Tests that the values are transferred from the database to the hashmap
        expectedHashMap = new HashMap<>(); //EmptyHashmap
        HashMap<String, Employee> actualHashmap = Manager.employees; // Reference to the real Hashmap
        dataBase = new DataBase();

        dataBase.readData(); // After this function actual hashmap should be full of Employee records.

        expectedHashMap.putAll(Manager.employees); // Put all employees into the expectedHashmap
        assertEquals(expectedHashMap,actualHashmap); // Hashmaps should be equal
    }
    @Test
    public void readDataNegative() { // Tests that the values are transferred from the database to the hashmap negatively.
        expectedHashMap = new HashMap<>(); //EmptyHashmap
        HashMap<String, Employee> actualHashmap = Manager.employees; // Reference to the real Hashmap
        dataBase = new DataBase();

        expectedHashMap.putAll(Manager.employees);// Put all employees into the expectedHashmap but actual hashmap is empty because we didn't start readData() function.

        dataBase.readData();// Put all employees into the expectedHashmap


        assertNotEquals(expectedHashMap,actualHashmap); // Hashmaps should not be equal
    }
}