import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerReportsAvgSalaryTest {
    double expected;
    double negativeExpected;
    DataBase dataBase=new DataBase();
    @Before
    public void setUp() throws Exception {
        expected=205280.21875;
        negativeExpected=124;
    }

    @After
    public void tearDown() throws Exception {
        expected=0;
        negativeExpected=0;
        Manager.employees.clear();
    }

    @Test
    public void reportsAvgSalaryPositiveTest() { // Test average salary of employees positively
        float totalSalary=0;
        float counter=0;
        float actual;
        dataBase.readData();
        for (String id : Manager.employees.keySet()) {
            totalSalary += Manager.employees.get(id).empSalary;
            counter++;
        }
        actual=totalSalary/counter;
        assertEquals(expected,actual,0);
    }
    @org.junit.Test
    public void reportsAvgSalaryNegativeTest(){// Test average salary of employees negatively
        float totalSalary=0;
        float counter=0;
        float actual;
        dataBase.readData();
        for (String id : Manager.employees.keySet()) {
            totalSalary += Manager.employees.get(id).empSalary;
            counter++;
        }
        actual=totalSalary/counter;
        assertNotEquals(negativeExpected,actual,0);
    }
}