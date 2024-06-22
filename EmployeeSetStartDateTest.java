import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeSetStartDateTest {
    String value1;
    String value2;
    Employee employee;
    @Before
    public void setUp() throws Exception {
        value1 = "12/11/2023";
        value2 = "12112023";
    }

    @After
    public void tearDown() throws Exception {
        value1 = null;
        value2 = null;
        Manager.employees.clear();
    }

    @Test
    public void setStartDatePositive() { // Tests the date format it should be like this (DD\MM\YYYY) if it is not it returns Today's date
        String expected = "12/11/2023";
        employee = new Employee();
        employee.setStartDate(value1);
        String actual = employee.getStartDate();
        assertEquals(expected,actual);
    }
    @Test
    public void setStartDateNegative() {// Tests the date format negatively. it returns Today's date
        String expected = "12112023";
        employee = new Employee();
        employee.setStartDate(value2);
        String actual = employee.getStartDate();
        assertNotEquals(expected,actual);
    }
}