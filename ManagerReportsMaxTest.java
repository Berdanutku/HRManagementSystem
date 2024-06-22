import static org.junit.Assert.*;

public class ManagerReportsMaxTest {
    float expected;
    float negativeExpected;
    DataBase dataBase=new DataBase();
    @org.junit.Before
    public void setUp() throws Exception {
        expected = 1234445;
        negativeExpected=124;
    }

    @org.junit.After
    public void tearDown() throws Exception {
        expected = 0;
        negativeExpected=0;
        Manager.employees.clear();
    }

    @org.junit.Test
    public void reportsMaxPositiveTest() { // test the max salary positively
        dataBase.readData();
        float actual=0;
        for (String id : Manager.employees.keySet()) {
            if (actual < Manager.employees.get(id).empSalary) {
                actual = Manager.employees.get(id).empSalary;
            }
        }
        assertEquals(expected,actual,0);
    }
    @org.junit.Test
    public void reportsMaxNegativeTest(){// test the max salary positively
        dataBase.readData();
        float actual=0;
        for (String id : Manager.employees.keySet()) {
            if (actual < Manager.employees.get(id).empSalary) {
                actual = Manager.employees.get(id).empSalary;
            }
        }
        assertNotEquals(negativeExpected,actual,0);
    }
}