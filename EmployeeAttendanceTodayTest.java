
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeAttendanceTodayTest {
    SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    String expected;

    @Before
    public void setUp() throws Exception {
        expected = obj.format(date);
    }

    @After
    public void tearDown() throws Exception {
        expected = null;
    }

    @Test
    public void attendanceTodayPositive() { // Tests whether or not the attendance of the employee is set to today
        String actual = "25/05/2023";
        assertEquals(expected,actual);

    }
    @Test
    public void attendanceTodayNegative(){ // Tests whether or not the attendance of the employee is not set to a previous date
        String actual="20/05/2023";
        assertNotEquals(expected,actual);
    }
}
