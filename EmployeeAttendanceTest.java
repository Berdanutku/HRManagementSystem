import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeAttendanceTest {
    float expected,NegativeExpected;
    String date1="12/05/2023";
    String date2="02/05/2023";
    SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");
    @Before
    public void setUp() throws Exception {
        expected=10;
        NegativeExpected = 15;
    }
    @After
    public void tearDown() throws Exception {
        expected=0;
        Manager.employees.clear();
    }

    @Test
    public void attendancePositive() throws ParseException { // Tests the difference between current date and start date positively
        Date datef1=obj.parse(date1);
        Date datef2=obj.parse(date2);

        float time_difference = datef1.getTime() - datef2.getTime();
        float days_difference = (time_difference / (1000*60*60*24)) % 365;

       assertEquals(expected,days_difference,0);
    }
    @Test
    public void attendanceNegative() throws ParseException { // Tests the difference between current date and start date negatively
        Date datef1=obj.parse(date1);
        Date datef2=obj.parse(date2);

        float time_difference = datef1.getTime() - datef2.getTime();
        float days_difference = (time_difference / (1000*60*60*24)) % 365;

        assertNotEquals(NegativeExpected,days_difference,0);
    }
}