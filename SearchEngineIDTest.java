import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SearchEngineIDTest {

    String value1, value2;
    private SearchEngine searchEngine = new SearchEngine();
    @Before
    public void setUp() throws Exception {
        value1 = "157";
        value2 = "1";
    }

    @After
    public void tearDown() throws Exception {
        value1 = null;
        value2 = null;
        Manager.employees.clear();
    }

    @Test
    public void searchByIDPositive() { // Tests whether or not the returned employee with the correct ID
        String expected = "157799";
        ArrayList<Employee> actual;
        DataBase db = new DataBase();
        db.readData();
        actual = searchEngine.searchByID(value1);
        assertEquals(expected, actual.get(0).getEmpID());
    }
    @Test
    public void searchByIDNegative() { // Tests whether or not the returned employee does not have wrong ID
        String expected = "418335";
        ArrayList<Employee> actual;
        DataBase db = new DataBase();
        db.readData();
        actual = searchEngine.searchByID(value2);
        assertNotEquals(expected,actual.get(0).getEmpID());
    }
}