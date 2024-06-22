import java.text.ParseException;
import java.util.Scanner;
public class Login {
    public void LoginPage() throws ParseException {
        String tempId;
        String tempPassword;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------Login-------------");
            System.out.println("ID (Enter '-1' to quit) ");
            tempId = scanner.next();

            if (tempId.equals("-1")){
                System.out.println("Quitting...");
                break;
            }
            System.out.println("Password");
            tempPassword = scanner.next();

            if (Authorization(tempId, tempPassword))
                Manager.employees.get(tempId).EmployeeMenu();
            else
                System.out.println("Wrong");
        }
    }
    public boolean Authorization(String Id,String Password){
        for (String employeeId : Manager.employees.keySet()){
            if (employeeId.equals(Id) && Manager.employees.get(employeeId).getEmpPass().equals(Password)){
                System.out.println("Logging...");
                return true;
            }
        }
        return false;
    }
}
