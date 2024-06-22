import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeSetPositionTest {
    private int value;
    @Before
    public void setUp() throws Exception {
        value = 1;
    }

    @After
    public void tearDown() throws Exception {
        value = 0;
        Manager.employees.clear();
    }

    @Test
    public void setPositionPositive() { // Tests the ordinal of Positions Enums returns corresponding int value
        Position expected = Position.HR;
        Employee employee = new Employee();
        employee.setPosition(value);
        Position actual = employee.position;
        assertEquals(expected,actual);
    }
    @Test
    public void setPositionNegative() { // Test negatively
        Position expected = Position.SOFTWARE;
        Employee employee = new Employee();
        employee.setPosition(value);
        Position actual = employee.position;
        assertNotEquals(expected,actual);
    }
}