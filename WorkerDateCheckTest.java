import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class WorkerDateCheckTest {

    private String todaysDate,pastDate;
    @Before
    public void setUp() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        todaysDate = formatter.format(date);
    }

    @After
    public void tearDown() throws Exception {
        todaysDate = null;
        pastDate = null;
    }

    @Test
    public void dateCheckerPositive() throws ParseException { // It tests when user enter past date it converts to today's date.
        pastDate = "24/05/2023";
        String expected = todaysDate;
        Worker worker = new Worker();
        String actual = worker.DateChecker(pastDate);

        assertEquals(expected,actual);
    }
    @Test
    public void dateCheckerNegative() throws ParseException { // It should not give us past date. It tests negatively.
        pastDate = "24/05/2023";
        String expected = pastDate;
        Worker worker = new Worker();
        String actual = worker.DateChecker(pastDate);

        assertNotEquals(expected,actual);
    }
}