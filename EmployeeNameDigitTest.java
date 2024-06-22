
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class EmployeeNameDigitTest {

    private String value1;

    @Before
    public void setUp() {
        value1 = "Ergin2001";
    }

    public void tearDown() {
        value1 = null;
        Manager.employees.clear();
    }

    @Test
    public void setNameTestPositive() { // Tests If String have any digits in it
        String expected = "Ergin";
        Worker worker = new Worker();
        worker.setEmpName(value1);
        String actual = worker.getEmpName();
        assertEquals(expected, actual);
    }

    @Test
    public void setNameTestNegative() { // It erases digits so it can not return String variables with digits in it
        String expected = "Ergin2001";
        Employee employee = new Employee();
        employee.setEmpName(value1);
        String actual = employee.getEmpName();
        assertNotEquals(expected,actual);
    }
}