import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeCreateEmployeeTest {
    private int value1,value2;
    @Before
    public void setUp() throws Exception {
        value1 = 1;
        value2 = 2;
    }

    @After
    public void tearDown() throws Exception {
        value1 = 0;
        value2 = 0;
        Manager.employees.clear();
    }

    @Test
    public void createEmployeePositive() { // Tests the set employees according to their position positively.
        Manager expected = new Manager();
        Employee actual;
        actual = Employee.createEmployee(value1);
        assertEquals(actual.getClass(),expected.getClass());
    }
    @Test
    public void createEmployeeNegative() {// Tests the set employees according to their position negatively.
        Manager expected = new Manager();
        Employee actual;
        actual = Employee.createEmployee(value2);
        assertNotEquals(actual.getClass(),expected.getClass());
    }
}