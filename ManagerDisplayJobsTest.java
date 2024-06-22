import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManagerDisplayJobsTest {
    Manager manager=new Manager();
    ArrayList expectedJobInfo=new ArrayList();
    ArrayList negativeExpectedJobInfo=new ArrayList();
    ArrayList jobInfo=new ArrayList();
    String expectedJobName;
    String expectedJobDesc;
    String expectedJobQual;
    int expectedJobSalary;

    String negativeExpectedJobName;
    String negativeExpectedJobDesc;
    String negativeExpectedJobQual;
    int negativeExpectedJobSalary;
    @Before
    public void setUp() throws Exception {
        expectedJobName="Developer";
        expectedJobDesc="Full-Time";
        expectedJobQual="Java";
        expectedJobSalary=15000;

        expectedJobInfo.add(expectedJobName);
        expectedJobInfo.add(expectedJobDesc);
        expectedJobInfo.add(expectedJobQual);
        expectedJobInfo.add(expectedJobSalary);

        negativeExpectedJobName="Manager";
        negativeExpectedJobDesc="Part-Time";
        negativeExpectedJobQual="Python";
        negativeExpectedJobSalary=20000;

        negativeExpectedJobInfo.add(negativeExpectedJobName);
        negativeExpectedJobInfo.add(negativeExpectedJobDesc);
        negativeExpectedJobInfo.add(negativeExpectedJobQual);
        negativeExpectedJobInfo.add(negativeExpectedJobSalary);
    }

    @After
    public void tearDown() throws Exception {
        expectedJobName=null;
        expectedJobDesc=null;
        expectedJobQual=null;
        expectedJobSalary=0;

        negativeExpectedJobName=null;
        negativeExpectedJobDesc=null;
        negativeExpectedJobQual=null;
        negativeExpectedJobSalary=0;
    }

    @Test
    public void displayJobsPositive() { // Tests whether or not the system is displaying the job announcements correctly
        ArrayList jobList=new ArrayList();
        String actualName="Developer";
        String actualDesc="Full-Time";
        String actualQual="Java";
        int actualSalary=15000;

        jobInfo.add(actualName);
        jobInfo.add(actualDesc);
        jobInfo.add(actualQual);
        jobInfo.add(actualSalary);

        manager.jobs.put(actualName,jobInfo);

        for (String name:manager.jobs.keySet()){
            jobList.add(manager.jobs.get(name));
        }
        for (int i=0;i<jobList.size();i++){
            assertEquals(expectedJobInfo,jobList.get(i));
        }
    }
    @Test
    public void displayJobsNegative(){ // Tests the system is not displaying the incorrect jobs
        ArrayList jobList=new ArrayList();
        String actualName="Developer";
        String actualDesc="Full-Time";
        String actualQual="Java";
        int actualSalary=15000;

        jobInfo.add(actualName);
        jobInfo.add(actualDesc);
        jobInfo.add(actualQual);
        jobInfo.add(actualSalary);

        manager.jobs.put(actualName,jobInfo);

        for (String name:manager.jobs.keySet()){
            jobList.add(manager.jobs.get(name));
        }
        for (int i=0;i<jobList.size();i++){
            assertNotEquals(negativeExpectedJobInfo,jobList.get(i));
        }
    }
}