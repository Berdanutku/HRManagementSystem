import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeSetPassTest {

    String value1;
    String value2;
    Employee employee;
    @Before
    public void setUp() throws Exception {
        value1 = "1234";
        value2 = "asdfa";
        employee = new Employee();
    }

    @After
    public void tearDown() throws Exception {
        value1 = null;
        Manager.employees.clear();
    }
    @Test
    public void setPasswordPositive(){ // Tests Password value it can only be digit
        String expected = "1234";
        employee.setEmpPass(value1);
        String actual = employee.getEmpPass();
        assertEquals(expected,actual);
    }
    @Test
    public void setPasswordNegative(){// Password cannot be String
        String expected = "asdfa";
        employee.setEmpPass(value2);
        String actual = employee.getEmpPass();
        assertNotEquals(expected,actual);
    }
}