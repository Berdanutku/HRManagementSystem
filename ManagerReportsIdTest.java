import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ManagerReportsIdTest {
DataBase dataBase=new DataBase();
String expected;
String negativeExpected;
    @Before
    public void setUp() throws Exception {
        expected="772826";
        negativeExpected="3";
    }

    @After
    public void tearDown() throws Exception {
        expected="0";
        negativeExpected="0";
        Manager.employees.clear();
    }
    @Test
    public void reportsIdPositiveTest() { // Test whether the Id is in the system or not positively.
        dataBase.readData();
        String actual="";
        if (Manager.employees.containsKey(expected)){
            actual=expected;
        }
        assertEquals(expected,actual);
    }
    @org.junit.Test
    public void reportsIdNegativeTest(){ // Test whether the Id is in the system or not negatively.
        dataBase.readData();
        String actual="";
        if (Manager.employees.containsKey(expected)){
            actual=expected;
        }
        assertNotEquals(negativeExpected,actual);
    }
}