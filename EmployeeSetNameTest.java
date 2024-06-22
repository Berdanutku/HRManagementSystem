import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeSetNameTest {
    private String value1;
    @Before
    public void setUp() throws Exception {
        value1 = "             Sami Kutay Erdoğan        ";
    }

    @After
    public void tearDown() throws Exception {
        value1 = null;
        Manager.employees.clear();
    }

    @Test
    public void setEmpNamePositive() { // Tests If String have a blank space's it trims.
        String expected = "Sami Kutay Erdoğan";
        Employee employee = new Employee();
        employee.setEmpName(value1);
        String actual = employee.getEmpName();

        assertEquals(expected,actual);
    }
    @Test
    public void setEmpNameNegative(){
        String expected = "             Sami Kutay Erdoğan        "; // It replace trims with "" so it cannot return spaces
        Employee employee = new Employee();
        employee.setEmpName(value1);
        String actual = employee.getEmpName();

        assertNotEquals(expected,actual);
    }
}