
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SearchEngine {

    private static Scanner scan = new Scanner(System.in); //Initializing static scanner for general usage

    public SearchEngine() { // Constructor
    }


    public void searchInDatabase() { // SearchEngine's main method that takes user input to categorize employees
        int choice;
        ArrayList<Employee> tempList;
        boolean isOn = true; //to control the workflow of the menu
        while (isOn) {
            System.out.println("---------------------------------------------");
            System.out.println("How would you like to search for the employee you are looking for?\n" +
                    "1-) By name\n2-) By ID\n3-) By department\nEnter:(-1 to exit)");
            try { // The manager deciding using which value to search for the employee
                choice = scan.nextInt(); scan.nextLine();
            } catch (InputMismatchException e) {
                choice = 10;
                scan.nextLine();
            }
            if (choice == 1) {
                System.out.println("Please enter the name of the employee you are looking for!" +
                        "(You can enter part of their name)\nEnter: ");
                String nameInput = scan.nextLine();
                tempList = searchByName(nameInput);
                if (tempList.isEmpty()) {
                    System.out.println("The employee with the name you are looking for could not be found in the system.");
                } else {
                    for (int i = 0; i < tempList.size(); i++) {
                        tempList.get(i).displayEmpRecs();
                    }
                }
            } else if (choice == 2) {
                System.out.println("Please enter the ID of the employee you are looking for!" +
                        "(You can enter part of their ID)\nEnter: ");
                String tempID = scan.nextLine();

                tempList = searchByID(tempID);
                if (tempList.isEmpty()) {
                    System.out.println("The employee with the ID you are looking for could not be found in the system.");
                } else {
                    for (int i = 0; i < tempList.size(); i++) {
                        tempList.get(i).displayEmpRecs();
                    }
                }
            } else if (choice == 3) {
                System.out.println("Please enter the department number of the employee you are looking for!" +
                        "\nEnter 0 for Software Department" +
                        "\nEnter 1 for HR Department" +
                        "\nEnter 2 for Quality Assurance Department" +
                        "\nEnter 3 for Accounting Department" +
                        "\nEnter 4 for Sales Department" +
                        "\nEnter 5 for Marketing Department" +
                        "\nEnter 6 for Product Department" +
                        "\nEnter: ");
                int tempPos;
                try {
                    tempPos = scan.nextInt(); scan.nextLine();
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    tempPos = 10;
                }
                tempList = searchByDepartment(tempPos);
                if (tempList.isEmpty()) {
                    System.out.println("The employees in the department you are looking for could not be found in the system.");
                } else {
                    for (int i = 0; i < tempList.size(); i++) {
                        tempList.get(i).displayEmpRecs();
                    }
                }
            } else if (choice == -1) {
                isOn= false;
                System.out.println("Navigating back to the previous menu...");
            } else
                System.out.println("Invalid User Input! Please Try Again...");
        }

    }
    public ArrayList<Employee> searchByName(String nameInput) { // Categorizes employees depending on their name
        ArrayList<Employee> foundEmps = new ArrayList<>(); // ArrayList for storing the found employees

        for (String s : Manager.employees.keySet()) {
            if (Manager.employees.get(s).getEmpName().contains(nameInput)) {
                foundEmps.add(Manager.employees.get(s)); // Storing found employees in list
            }
        }
        return foundEmps;
    }
    public ArrayList<Employee> searchByID(String tempID) { // Categorizes employees depending on their ID
        ArrayList<Employee> foundEmps = new ArrayList<>(); // ArrayList for storing the found employees

        for (String s : Manager.employees.keySet()) {
            if (Manager.employees.get(s).getEmpID().contains(tempID)) {
                foundEmps.add(Manager.employees.get(s)); // Storing found employees in list
            }
        }
        return foundEmps;
    }
    public ArrayList<Employee> searchByDepartment(int tempPos) { // Categorizes employees depending on their Department
        ArrayList<Employee> foundEmps = new ArrayList<>(); // ArrayList for storing the found employees

        for (String s : Manager.employees.keySet()) {
            if (Manager.employees.get(s).getPosition() == tempPos) {
                foundEmps.add(Manager.employees.get(s)); // Storing found employees in list
            }
        }
        return foundEmps;
    }
}
