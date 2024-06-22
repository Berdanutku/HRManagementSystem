import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ManagerSendAnnouncementsTest {
    String expected;
    String negativeExpected;
    @Before
    public void setUp() throws Exception {
        expected="Announcement";
        negativeExpected="asdjhfsdd";
    }

    @After
    public void tearDown() throws Exception {
        expected=null;
        negativeExpected=null;
        Manager.announcements.clear();
        Manager.employees.clear();
    }

    @Test
    public void sendAnnouncementsPositiveTest() { // Test whether or not announcements contains correct values
        String actual="Announcement";
        Manager.announcements.add(actual);
        if (Manager.announcements.contains(expected)){
            assertEquals(expected,actual);
        }
    }
    @Test
    public void sendAnnouncementNegativeTest(){ // Test whether or not announcements doesn't contain incorrect values
        String actual="Announcement";
        Manager.announcements.add(actual);
        if (Manager.announcements.contains(negativeExpected)){
            assertEquals(negativeExpected,actual);
        }
        else {
            assertNotEquals(negativeExpected,actual);
        }
    }
}