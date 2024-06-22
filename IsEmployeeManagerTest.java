import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsEmployeeManagerTest {
    Employee employee=new Employee();
    Manager manager=new Manager();
    String expected;
    String negativeExpected;

    @Before
    public void setUp() throws Exception {
        employee.setEmpID("1111");
        expected="1111";
        negativeExpected="0000";
    }
    @After
    public void tearDown() throws Exception {
        expected=null;
    }
    @Test
    public void IsEmployeeManagerPositive(){ // Tests whether or not mutators and accessors are working correctly

        String actual=employee.getEmpID();
        assertEquals(expected,actual);
    }
    @Test
    public void IsEmployeeManagerNegative(){ // Tests whether or not mutators and accessors are returning wrong values
        String actual=employee.getEmpID();
        assertNotEquals(negativeExpected,actual);
    }
}