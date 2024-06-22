import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerReportsTotalSalaryTest {
    float expected;
    float negativeExpected;
    DataBase dataBase=new DataBase();
    @Before
    public void setUp() throws Exception {
        expected=1847522;
        negativeExpected=124;
    }

    @After
    public void tearDown() throws Exception {
        expected=0;
        negativeExpected=0;
        Manager.employees.clear();
    }
    @Test
    public void reportsTotalSalaryPositiveTest() { // Test the total salary of the employees positively.
        float actual=0;
        dataBase.readData();
        for (String id : Manager.employees.keySet()) {
            actual += Manager.employees.get(id).empSalary;
        }
        assertEquals(expected,actual,0);
    }
    @org.junit.Test
    public void reportsTotalSalaryNegativeTest(){ // Test the total salary of the employees negatively.
        float actual=0;
        dataBase.readData();
        for (String id : Manager.employees.keySet()) {
            actual += Manager.employees.get(id).empSalary;
        }
        assertNotEquals(negativeExpected,actual,0);
    }
}