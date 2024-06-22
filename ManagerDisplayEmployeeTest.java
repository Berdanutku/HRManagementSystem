import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerDisplayEmployeeTest {
    String id;
    String expectedName;
    String expectedPassword;
    String expectedAddress;
    float expectedSalary;
    String negativeExpectedName;
    String negativeExpectedPassword;
    String negativeExpectedAddress;
    float negativeExpectedSalary;


    @Before
    public void setUp() throws Exception { // Creating expected values
        id="418335";
        expectedName="Vedat Erdöl";
        expectedPassword="1234";
        expectedAddress="Ankara caddesi No: 7 96 t İzmir";
        expectedSalary= 23000.0F;

        negativeExpectedName="Ahmet";
        negativeExpectedPassword="0000";
        negativeExpectedAddress="Balçova";
        negativeExpectedSalary=12000.0F;

    }

    @After
    public void tearDown() throws Exception {
        id=null;
        expectedName=null;
        expectedPassword=null;
        expectedAddress=null;
        expectedSalary=0;
        Manager.employees.clear();
    }

    @Test
    public void displayEmployeePositive() { // Tests whether or not the system is displaying the employee records correctly
        DataBase dataBase=new DataBase();
        dataBase.readData();
        String actualName="";
        String actualPassword="";
        String actualAddress="";
        float actualSalary=0;

        actualName=Manager.employees.get(id).getEmpName();
        actualPassword=Manager.employees.get(id).getEmpPass();
        actualAddress=Manager.employees.get(id).getEmpAddress();
        actualSalary=Manager.employees.get(id).getEmpSalary();

        assertEquals(expectedName,actualName);
        assertEquals(expectedPassword,actualPassword);
        assertEquals(expectedAddress,actualAddress);
        assertEquals(expectedSalary,actualSalary,0);
    }
    @Test
    public void displayEmployeeNegative(){ // Tests whether or not the system is not printing different employee records
        DataBase dataBase=new DataBase();
        dataBase.readData();
        String actualName="";
        String actualPassword="";
        String actualAddress="";
        float actualSalary=0;

        actualName=Manager.employees.get(id).getEmpName();
        actualPassword=Manager.employees.get(id).getEmpPass();
        actualAddress=Manager.employees.get(id).getEmpAddress();
        actualSalary=Manager.employees.get(id).getEmpSalary();

        assertNotEquals(negativeExpectedName,actualName);
        assertNotEquals(negativeExpectedPassword,actualPassword);
        assertNotEquals(negativeExpectedAddress,actualAddress);
        assertNotEquals(negativeExpectedSalary,actualSalary);


    }
}