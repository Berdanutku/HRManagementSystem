import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataBaseDeletePermissionTest {
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
    public void deletePermissionPositive() { // Tests if the entered data has been deleted from the database
        Worker expected = null;

        dataBase.readData(); // Read employees from the database
        dataBase.readPermission(); // Read permissions from the database

        worker.sendRequest(); // Sending request and write it to the database

        Worker.requestHash.remove("12345"); // remove it from the hash
        dataBase.deletePermission(); // also remove it from the database

        dataBase.readPermission(); // Read permissions from the database again. To see request deleted or not

        assertNull(Worker.requestHash.get("12345")); // request should be deleted
    }
    @Test
    public void deletePermissionNegative() { // Tests if the entered data has been deleted from the database
        Worker expected = worker;

        dataBase.readData();// Read employees from the database
        dataBase.readPermission();// Read permissions from the database

        worker.sendRequest();// Sending request and write it to the database

        Worker.requestHash.remove("12345");// remove it from the hash
        dataBase.deletePermission();// also remove it from the database

        dataBase.readPermission();// Read permissions from the database again. To see request deleted or not

        assertNotEquals(expected,Worker.requestHash.get("12345")); // request should be deleted
    }
}