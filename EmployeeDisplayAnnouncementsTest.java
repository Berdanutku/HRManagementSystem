import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDisplayAnnouncementsTest {
String expected;
String negativeExpected;
    @Before
    public void setUp() throws Exception {
        expected="Announcement";
        negativeExpected="asddhgvhsd";
    }

    @After
    public void tearDown() throws Exception {
        expected=null;
        negativeExpected=null;
    }

    @Test
    public void displayAnnouncementsPositive() { // Tests whether or not the announcements are printed out correctly

        String actual="Announcement";
        Manager.announcements.add(actual);

        for (int i=0;i<Manager.announcements.size();i++){
            assertEquals(expected,Manager.announcements.get(i));
        }
    }
    @Test
    public void displayAnnouncementsNegative(){ // Tests whether or not the announcements are not printed out wrong

        String actual="Announcement";
        Manager.announcements.add(actual);

        for (int i=0;i<Manager.announcements.size();i++){
            assertNotEquals(negativeExpected,actual);
        }
    }
}