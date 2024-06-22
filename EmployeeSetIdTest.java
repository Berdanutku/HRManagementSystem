import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeSetIdTest {
    String Id;
    Employee employee1;
    @Before
    public void setUp() throws Exception {
        Id = "100000"; // start Id
        for (int i = 100000; i < 999999 ; i++){
            Employee employee = new Employee(); // This Loops create 999998 employees object.
            employee.setEmpID(Integer.toString(i));
            Manager.employees.put(Integer.toString(i),employee); // put employees into static employee hashmap (key = Id , value = Employee Object)
        }

    }

    @After
    public void tearDown() throws Exception {
        Id = null;
        Manager.employees.clear();
    }

    @Test
    public void setEmpIDPositive() { // Test Our new employee1 can get different Id then other employees with a 100000 to 999999 interval
        String expected = "999999"; // expected value

        employee1 = new Employee(); // creating employee1
        employee1.setEmpID(Id); //start Id is 100000
        String actual = employee1.getEmpID();
        assertEquals(expected,actual);  // actual Id should be 999999 because other employee's Id values are between 100000 to 999998
    }
    @Test
    public void setEmpIDNegative() {
        String expected = "999998";
        Employee employee1 = new Employee();
        employee1.setEmpID(Id); //start Id is 100000
        String actual = employee1.getEmpID();
        assertNotEquals(expected,actual); // actual Id shouldn't get value between 100000 to 999998. It only gets 999999
    }
}