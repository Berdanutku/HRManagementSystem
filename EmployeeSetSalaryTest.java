import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeSetSalaryTest {
    private float value1;
    @Before
    public void setUp() throws Exception {
        value1 = -10;
    }

    @After
    public void tearDown() throws Exception {
        value1 = 0;
        Manager.employees.clear();
    }

    @Test
    public void setEmpSalaryPositive() { // Tests if salary value has a below zero it returns the absolute value of that value
        float expected = 10;
        Employee employee = new Employee();
        employee.setEmpSalary(value1);
        float actual = employee.getEmpSalary();
        assertEquals(expected,actual,0);
    }
    @Test
    public void setEmpSalaryNegative() {// Salary cannot below zero
        float expected = -10;
        Employee employee = new Employee();
        employee.setEmpSalary(value1);
        float actual = employee.getEmpSalary();
        assertNotEquals(expected,actual,0);
    }
}