import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SearchEngineDepartmentTest {

    private int value1, value2;
    private SearchEngine searchEngine = new SearchEngine();
    @Before
    public void setUp() throws Exception {
        value1 = 1;
        value2 = 3;
    }

    @After
    public void tearDown() throws Exception {
        value1 = 0;
        value2 = 0;
        Manager.employees.clear();
    }

    @Test
    public void searchByDepartmentPositive() { // Tests whether or not the returned employee has correct position/department values
        Position expected = Position.HR;
        ArrayList<Employee> actual;
        DataBase db = new DataBase();
        db.readData();
        actual = searchEngine.searchByDepartment(value1);
        assertEquals(expected, actual.get(0).position);
    }
    @Test
    public void searchByDepartmentNegative() { // Tests if the search engine found employees with incorrect position values
        Position expected = Position.HR;
        ArrayList<Employee> actual;
        DataBase db = new DataBase();
        db.readData();
        actual = searchEngine.searchByDepartment(value2);
        assertNotEquals(expected,actual.get(0).position);
    }
}