import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginAuthorizationTest {
    Employee employee;
    String Id,Password;

    @Before
    public void setUp() throws Exception {
        Id = "100005"; //setting initial ID
        Password = "1234";//setting initial Password
        for (int i = 100000; i < 100010 ; i++) { // creating 10 employees which their password is "1234" and ID is i
            employee = new Employee();
            employee.setEmpID(Integer.toString(i));// setting Id
            employee.setEmpPass(Password); // setting password
            Manager.employees.put(employee.getEmpID(),employee); // Put employees into hashmap
        }
    }

    @After
    public void tearDown() throws Exception {
        Password = null;
        Id = null;
        Manager.employees.clear(); // clear Hashmap
    }

    @Test
    public void authorizationPositive() { // Id and password pair is included in hashmap that's why Authorization function should return true
        boolean expected = true;
        Login login = new Login();
        boolean actual = login.Authorization(Id,Password);

        assertEquals(expected,actual);
    }
    @Test
    public void authorizationNegative() {   // Id and password pair is included in hashmap that's why Authorization function should return true.
        boolean expected = false;
        Login login = new Login();
        boolean actual = login.Authorization(Id,Password);

        assertNotEquals(expected,actual);
    }

}