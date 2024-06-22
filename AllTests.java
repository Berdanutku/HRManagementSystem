import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        DataBaseReadDataTest.class,
        EmployeeAttendanceTest.class,
        EmployeeAttendanceTodayTest.class,
        EmployeeCreateEmployeeTest.class,
        EmployeeDisplayAnnouncementsTest.class,
        EmployeeNameDigitTest.class,
        EmployeeSetIdTest.class,
        EmployeeSetNameTest.class,
        EmployeeSetPassTest.class,
        EmployeeSetPositionTest.class,
        EmployeeSetSalaryTest.class,
        EmployeeSetStartDateTest.class,
        ManagerReportsAvgSalaryTest.class,
        ManagerReportsIdTest.class,
        ManagerReportsMaxTest.class,
        ManagerReportsMinTest.class,
        ManagerReportsTotalSalaryTest.class,
        ManagerDisplayEmployeeTest.class,
        ManagerDisplayJobsTest.class,
        ManagerJobPostTest.class,
        ManagerSendAnnouncementsTest.class,
        IsEmployeeManagerTest.class,
        LoginAuthorizationTest.class,
        LoginAuthotizationPasswordTest.class,
        SearchEngineDepartmentTest.class,
        SearchEngineIDTest.class,
        SearchEngineNameTest.class,
        WorkerDateCheckTest.class,
        WorkerSendRequestTest.class,
        DataBaseDeletePermissionTest.class
})
public class AllTests {

}
