import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerReportsMinTest {
    float expected;
    float negativeExpected;
    DataBase dataBase=new DataBase();
    @Before
    public void setUp() throws Exception {
        expected=12000;
        negativeExpected=124;
    }

    @After
    public void tearDown() throws Exception {
        expected = 0;
        negativeExpected=0;
        Manager.employees.clear();
    }

    @Test
    public void reportsMinPositiveTest() {// test the min salary positively
        dataBase.readData();
        float actual=999999999;
        for (String id :Manager.employees.keySet()) {
            if (actual > Manager.employees.get(id).empSalary) {
                actual = Manager.employees.get(id).empSalary;
            }
        }
        assertEquals(expected,actual,0);
    }
    @org.junit.Test
    public void reportsMinNegativeTest(){// test the min salary negatively
        dataBase.readData();
        float actual=999999999;
        for (String id :Manager.employees.keySet()) {
            if (actual > Manager.employees.get(id).empSalary) {
                actual = Manager.employees.get(id).empSalary;
            }
        }
        assertNotEquals(negativeExpected,actual,0);
    }
}