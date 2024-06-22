import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SearchEngineNameTest {

    String value1, value2;
    private SearchEngine searchEngine = new SearchEngine();
    @Before
    public void setUp() throws Exception {
        value1 = "Ergin";
        value2 = "Selami";
    }

    @After
    public void tearDown() throws Exception {
        value1 = null;
        value2 = null;
        Manager.employees.clear();
    }

    @Test
    public void searchByNamePositive() { // Tests whether or not the returned employee with the correct Name
        String expected = "Ergin Yalman";
        ArrayList<Employee> actual;
        DataBase db = new DataBase();
        db.readData();
        actual = searchEngine.searchByName(value1);
        assertEquals(expected, actual.get(0).getEmpName());
    }
    @Test
    public void searchByNameNegative() {  // Tests whether or not the returned employee does not have wrong Name
        String expected = "Vedat Erdöl";
        ArrayList<Employee> actual;
        DataBase db = new DataBase();
        db.readData();
        actual = searchEngine.searchByName(value2);
        assertNotEquals(expected,actual.get(0).getEmpName());
    }
}