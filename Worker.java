import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Worker extends Employee{

    public static HashMap<String,Employee> requestHash = new HashMap<>(); // creating static request hashmap to know active requests.
    public Worker() {}

    @Override
    public void EmployeeMenu() throws ParseException { // Menu for Workers
        Scanner input=new Scanner(System.in);
        System.out.println("Hello " + getEmpName());
        System.out.println("Welcome to the HR Management System");
        while (true) { // menu
            System.out.println();
            System.out.println("1-Display Records \n2-Update Personal Information \n3-Display Announcements\n4-Request Appointment  \n0-Quit");
            System.out.println("Please select an option: ");
            int option = input.nextInt();
            switch (option) {
                case 1 -> displayEmpRecs();
                case 2 -> sendRequest();
                case 3 -> displayAnnouncements();
                case 4 -> requestAppointment();
                case 0 -> System.out.println("Quitting...");
                default -> System.out.println("Invalid Input!");
            }
            if (option == 0) {
                break;
            }
        }
    }

    public void sendRequest(){ // sends request to Hr manager to update their record's

        DataBase dataBase = new DataBase();
        dataBase.readPermission(); // it reads the permission's in our database and put into the request hashmap.
        if (!request){ // if worker doesn't send request. He sends request
            if (requestHash.containsKey(getEmpID())){// if he already sends it, but It didn't approve by Hr then he cannot send more than one.
                System.out.println("Cannot sending request more than one");
                return;
            }
            System.out.println("Sending Request for Update Personal Information");
            dataBase.writePermission(this);
            requestHash.put(getEmpID(),this);
        }
        else { // If his reques has been approved by Hr manager now worker can alter their information.
            System.out.println("Your request has been approved by HR management");
            updateEmployee(); // side effect
            request = false;
            requestHash.remove(this.getEmpID());
            dataBase.deletePermission();
        }
    }
    public void requestAppointment() throws ParseException {
        String tempName,temDate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hr Managers");
        for(String Id : Manager.employees.keySet()){
            if (Manager.employees.get(Id).getPosition() == 1)
                System.out.println(Manager.employees.get(Id).getEmpName());
        }
        System.out.println("Enter Manager name:");
        tempName = scanner.nextLine();
        for (String tempId : Manager.employees.keySet()){
            if (Manager.employees.get(tempId).getEmpName().equals(tempName)){
                System.out.println("Date : ");
                temDate = scanner.next();
                String[] a = new String[2];
                a[0] = temDate;
                a[1] = getEmpID();
                Manager.employees.get(tempId).getAppointments().add(a);
                DataBase dataBase = new DataBase();
                dataBase.writeAppointment(Manager.employees.get(tempId),this,DateChecker(temDate));
            }
        }
    }

    public String DateChecker(String Date) throws ParseException {
        if (new SimpleDateFormat("dd/MM/yyyy").parse(Date).before(new Date())) {
            System.out.println("You cannot Appoint before todays date");
            System.out.println("Set date today");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            return formatter.format(date);
        }
        return Date;
    }
    public void updateEmployee() { // if Hr manager gives permission, worker can update him/her records
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee address [" + getEmpAddress() + "]: ");
        String address = scanner.nextLine().trim();
        if (!address.isEmpty()) {
            setEmpAddress(address);
        }
        DataBase dataBase = new DataBase(); // initialize new database to update it
        dataBase.updateData(getEmpID()); // updates the database with changed employee records
        System.out.println("Employee record updated successfully!");
    }
}
