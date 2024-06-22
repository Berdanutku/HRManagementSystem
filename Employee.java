import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee {
    protected String empID; // Employee ID
    protected String empPass; // Employee Password
    protected String empName; // Employee Name
    protected String empAddress; // Employee Address
    protected float empSalary; // Employee Salary
    protected ArrayList<Review> perfReviews = new ArrayList<>(); // Employee Performance Reviews
    protected ArrayList<String[]> appointments = new ArrayList<>();
    protected String startDate; // Employee Starting Date for Job
    protected Position position; // Employee Position
    public String attendance;
    public boolean request;

    public Employee(String empID, String empName, String empPass, Position empPosition, String empAddress, float empSalary, String startDate) {
        this.empID = empID;
        this.empPass = empPass;
        this.empName = empName;
        this.position = empPosition;
        this.empAddress = empAddress;
        this.empSalary = empSalary;
        this.startDate = startDate;
    }

    public static Employee createEmployee(int i) { // checks whether or not the object is employee or HR manager depending on its Position information
        if (i == 1) {
            return new Manager(); // if position is 2 then it creates Manager object.
        } else return new Worker(); // else creates Employee for now.
    }

    public Employee() {
    } // default constructor

    public void EmployeeMenu() throws ParseException {}

    public String getEmpID() { // get method for employee's ID
        return empID;
    }

    public void setEmpID(String empID) { // set method for employee's ID
        if (Manager.employees.containsKey(empID)){
            System.out.println("This Id is already taken" );
            System.out.println("Creating Random Id");

            int Id = new Random().nextInt(900000) + 100000; // creating random ID to the employee
            while (Manager.employees.containsKey(Integer.toString(Id))) { // checking whether or not the unique ID is already exists, if so incremented by 1.
                if (Id > 1000000){ // if exceeds its limits set ID to 0
                    System.out.println("There are no space for new Employee Id");
                    System.out.println("Setting Id to 0");
                    Id = 0;
                    break;
                }
                Id++;
            }
            empID = Integer.toString(Id);
        }
        this.empID = empID;
    }

    public String getEmpPass() { // get method for employee's Password
        return empPass;
    }

    public void setEmpPass(String empPass) { // set method for employee's Password
        String regex = "\\d+"; // only digits
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(empPass).matches()) // If password only contains digit. It sets to actual password
            this.empPass = empPass;
        else{
            System.out.println("Only digits!");
            System.out.println("Setting Temporary Password: 0000");
            setEmpPass("0000");
        }
    }

    public String getEmpName() { // get method for employee's Name
        return empName;
    }

    public void setEmpName(String empName) { // set method for employee's Name
        empName = empName.replaceAll("[0123456789]", ""); // deletes digits
        this.empName = empName.trim(); // deletes blanks
    }

    public String getEmpAddress() { // get method for employee's Address
        return empAddress;
    }

    public void setEmpAddress(String empAddress) { // set method for employee's Address
        this.empAddress = empAddress;
    }

    public float getEmpSalary() { // get method for employee's Salary
        return empSalary;
    }

    public void setEmpSalary(float empSalary) { // set method for employee's Salary
        if (empSalary < 0) {         // checking salaries if salaries is below zero changing with absolute value
            System.out.println("Salaries cannot below zero");
            empSalary = Math.abs(empSalary);
        }
        this.empSalary = empSalary;
    }

    public ArrayList<Review> getPerfReviews() { // get method for employee's personal Performance Review List
        return perfReviews;
    }

    public void setPerfReviews(ArrayList<Review> perfReviews) { // set method for employee's personal Performance Review List
        this.perfReviews = perfReviews;
    }

    public String getStartDate() { // get method which returns the employee's work starting date in the company
        return startDate;
    }

    public void setStartDate(String startDate) { // set method for employee's work starting date in the company
        String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"; // regular expression for date (DD\MM\YYYY)
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(startDate).matches()) // if fits the condition it sets date
            this.startDate = startDate;
        else { // if not it set the date today's date
            System.out.println("Wrong date!  Date format should be like this: (DD\\MM\\YYYY)");
            System.out.print("Start date updated to today's date: ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            this.startDate = formatter.format(date);
            System.out.println(this.startDate);
        }
    }

    void displayEmpRecs() { // Method for displaying employee's personal records in the system
        System.out.println("---------------------------------------------");
        System.out.println("Name : " + getEmpName());
        System.out.println("ID : " + getEmpID());
        System.out.println("Password : " + getEmpPass());
        System.out.println("Address : " + getEmpAddress());
        System.out.println("Salary : " + getEmpSalary());
        System.out.println("Position : " + position);
        System.out.println("Date : " + getStartDate());
    }

    public int getPosition() { // get method for the position/returns as an integer value
        return position.ordinal();
    }

    public void setPosition(int position) { // set method for the position value of the employee
        switch (position) {

            case 0 -> this.position = Position.SOFTWARE;
            case 1 -> this.position = Position.HR;
            case 2 -> this.position = Position.QA;
            case 3 -> this.position = Position.ACCOUNTANT;
            case 4 -> this.position = Position.SALES;
            case 5 -> this.position = Position.MARKETING;
            case 6 -> this.position = Position.PRODUCT;
            default -> this.position = null;
        }
    }

    public ArrayList<String[]> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<String[]> appointments) {
        this.appointments = appointments;
    }

    public void Attendance() throws ParseException { //gets ID from HR and calculates employee's attendance
        SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Employee ID to view Employee's attendance:");
        String id=input.nextLine();

        String sDate=Manager.employees.get(id).startDate;
        attendance="Current Date:"+obj.format(date)+"----"+"Start Date:"+sDate;
        Date date1=obj.parse(obj.format(date));
        Date date2=obj.parse(sDate);
        long time_difference = date1.getTime() - date2.getTime(); //finds the difference between the current date and the start date.
        long days_difference = (time_difference / (1000*60*60*24)) % 365;
        long years_difference = (time_difference / (1000l*60*60*24*365));

        System.out.println(Manager.employees.get(id).empName);
        System.out.println(attendance);
        System.out.println("Employee's attendance is "+years_difference+" years "+days_difference+" days.");
    }

    public void displayAnnouncements(){
        System.out.println("ANNOUNCEMENTS");
        for (int i=0;i<Manager.announcements.size();i++){
            System.out.println(i+1+"-"+Manager.announcements.get(i));
        }
    }

    public void addEmployee() {}

    public void displayEmployee() {}

    public void updateEmployee() {}

    public void jobPost() {}

    public void displayJobs() {}
    public void sendRequest(){}
    public void requests(){}
    public void reports(){}
}
