import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerSendRequestTest {
    private Worker worker;
    private DataBase dataBase;

    @Before
    public void setUp() throws Exception {
        dataBase = new DataBase();
        worker = new Worker();
        worker.setEmpID("12345");
        Manager.employees.put("12345",worker);

    }

    @After
    public void tearDown() throws Exception {
        Worker.requestHash.clear();
        Manager.employees.clear();
    }

    @Test
    public void sendRequestPositive() { // test whether worker sends the request. function should store it into the hashmap
        boolean expected = false;

        dataBase.readData();
        dataBase.readPermission();

        worker.sendRequest();
        Employee actual = Worker.requestHash.get("12345");

        assertEquals(expected,actual.request); // request variable should be same with requestHash
    }
    @Test
    public void sendRequestNegative() { // the request in the hashmap and the request of the worker must be the same.
        boolean expected = true;

        dataBase.readData();
        dataBase.readPermission();

        worker.sendRequest();
        Employee actual = Worker.requestHash.get("12345");

        assertNotEquals(expected,actual.request); // request variable should same with requestHash
    }
}