import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Manager extends Employee { // Manager class, which is an Employee but has more authorization
    private String jobName;
    private String jobDesc;
    private String jobQual;
    private int jobSalary;
    HashMap<String, ArrayList> jobs = new HashMap(); // posted jobs
    static HashMap<String, Employee> employees = new HashMap<>(); // Hashmap data structure which keeps the employees information, key is the employee's ID
    static ArrayList<String> announcements=new ArrayList();

    public Manager(String managerID, String managerName, String managerPass, Position managerPosition,
                   String managerAddress, float managerSalary, String startDate) { // Constructor for the Manager object
        super(managerID, managerName, managerPass, managerPosition, managerAddress, managerSalary, startDate); // super method
        setPosition(1); // sets position as HR manager automatically
    }

    public Manager() {
    } // default constructor.
    @Override
    public void EmployeeMenu() throws ParseException {
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to the HR Management System");
        checkDateForAppointments();
        while (true) { // menu
            System.out.println();
            System.out.println("1-Add Employee \n2-Display Employee \n3-Update Employee \n4-Post a Job \n5-Display Jobs\n6-Display Requests \n7-Display Reports\n8-Display Attendance\n9-Send an Announcement\n10-Display Appointments\n11-Search for Employee \n0-Quit");
            System.out.println("Please select an option: ");
            int option = input.nextInt();
            switch (option) {
                case 1 -> addEmployee();
                case 2 -> displayEmployee();
                case 3 -> updateEmployee();
                case 4 -> jobPost();
                case 5 -> displayJobs();
                case 6 -> requests();
                case 7 -> reports();
                case 8 -> Attendance();
                case 9 -> sendAnnouncements();
                case 10 -> displayAppointments();
                case 11 -> searchForEmp();
                case 0 -> System.out.println("Quitting...");
                default -> System.out.println("Invalid Input!");
            }
            if (option == 0) {
                break;
            }
        }
    }

    public void searchForEmp() {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.searchInDatabase();
    }
    public void addEmployee() { // add employee method

        int Id = new Random().nextInt(900000) + 100000; // creating unique ID to the employee

        try {
            String tempName, tempPassword, tempAddress, tempId = Integer.toString(Id);
            float tempSalary;                                            // declaring Temporary attributes
            Date tempStartDate = new Date();
            int tempPosition;

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            Scanner scanner = new Scanner(System.in); // creating scanner for User input to necessary employee records

            Employee employee; // Creating default constructor

            System.out.println("Employee Position");
            int i = 1;
            for (Position position : Position.values()) { // Listing positions
                System.out.println((position.ordinal()) + " " + position);
                i++;
            }
            tempPosition = scanner.nextInt();
            employee = Employee.createEmployee(tempPosition);// User input for positions
            employee.setPosition(tempPosition); // setting positions
            scanner.nextLine();

            System.out.println("Employee Name");
            tempName = scanner.nextLine(); // User input for employee name
            employee.setEmpName(tempName);  // setting employee name

            System.out.println("Employee Password (Password only contains digits)");
            tempPassword = scanner.next(); // User input for employee password
            employee.setEmpPass(tempPassword);  // setting employee password
            scanner.nextLine();

            System.out.println("Employee Address");
            tempAddress = scanner.nextLine();  // User input for employee address
            employee.setEmpAddress(tempAddress); // setting employee address

            try {        // Exception handling for if Salary is a String
                System.out.println("Employee Salary");
                tempSalary = Float.parseFloat(scanner.nextLine()); // Converting String to Float type
                employee.setEmpSalary(tempSalary);
            } catch (NumberFormatException e) {
                System.out.println("Salary cannot be String");
                System.out.println("Updating salary to zero");
                employee.setEmpSalary(0);   // setting salary 0
            }

            employee.setStartDate(tempStartDate.toString()); // setting Start Date to "now"
            employee.setEmpID(tempId);
            DataBase dataBase = new DataBase(); // initializing new DataBase
            dataBase.writeData(employee); // adding the employee to the database
            employees.put(tempId, employee); // adding employee to the Hashmap

        } catch (Exception e) {
            System.out.println("Invalid input for position!");
            System.out.println("The position set to null.");
        } finally {
            System.out.println("Employee information added");
        }
    }


    public void displayReviews(Employee e) { // display method for the employee's performance reviews
        Scanner scan = new Scanner(System.in);
        int temp;
        if (!e.getPerfReviews().isEmpty()) { // checks if the employee has existing reviews, if so displays them
            for (int i = 0; i < e.getPerfReviews().size(); i++) {
                System.out.println("\n" + e.getEmpName() + "'s Performance Review - " + (i + 1) +
                        "\nQuality of Work:\t" + e.getPerfReviews().get(i).getQofW() +
                        "\nAttendance & Punctuality:\t" + e.getPerfReviews().get(i).getAandP() +
                        "\nCommunication Skills:\t" + e.getPerfReviews().get(i).getComm() +
                        "\nJudgment & Decision Making:\t" + e.getPerfReviews().get(i).getJandDM() +
                        "\nCooperation & Teamwork:\t" + e.getPerfReviews().get(i).getCoop() +
                        "\n---------------------------\n");
            }

        }
        System.out.println("What action do you wish to take?\n" +
                "1 - Add new performance review\n" +
                "2 - Return back to menu\n\n" +
                "Enter:");
        temp = scan.nextInt();
        scan.nextLine();

        while (true) {
            if (temp == 1) {
                addPerfReview(e); // adding reviews to the employees Performance Review List
                break;
            } else if (temp == 2) {
                break; // returns back to the menu
            } else {
                System.out.println("Invalid Input!" + "\n\nPlease enter again:");
                temp = scan.nextInt();
                scan.nextLine();
            }
        }
    }

    public void addPerfReview(Employee e) { // creates a new performance review of the employee
        Scanner scan = new Scanner(System.in);
        int tempQofW, tempAandP, tempComm, tempJandDM, tempCoop, choice; // temporary review class attributes
        System.out.println("Quality of Work (1 to 4): \n" +
                "1 - Unacceptable\n" +
                "2 - Needs development\n" +
                "3 - Meets expectations \n" +
                "4 - Exceeds expectations\n" +
                "\n" +
                "Enter:");
        tempQofW = scan.nextInt();
        scan.nextLine();

        System.out.println("\n" +
                "Attendance & Punctuality (1 to 4): \n" +
                "1 - Unacceptable\n" +
                "2 - Needs development\n" +
                "3 - Meets expectations \n" +
                "4 - Exceeds expectations\n" +
                "\n" +
                "Enter:");
        tempAandP = scan.nextInt();
        scan.nextLine();

        System.out.println("\n" +
                "Communication Skills (1 to 4): \n" +
                "1 - Unacceptable\n" +
                "2 - Needs development\n" +
                "3 - Meets expectations \n" +
                "4 - Exceeds expectations\n" +
                "\n" +
                "Enter:");
        tempComm = scan.nextInt();
        scan.nextLine();

        System.out.println("Judgment & Decision Making (1 to 4): \n" +
                "1 - Unacceptable\n" +
                "2 - Needs development\n" +
                "3 - Meets expectations \n" +
                "4 - Exceeds expectations\n" +
                "\n" +
                "Enter:");
        tempJandDM = scan.nextInt();
        scan.nextLine();

        System.out.println("Cooperation & Teamwork (1 to 4): \n" +
                "1 - Unacceptable\n" +
                "2 - Needs development\n" +
                "3 - Meets expectations \n" +
                "4 - Exceeds expectations\n" +
                "\n" +
                "Enter:");
        tempCoop = scan.nextInt();
        scan.nextLine();
        int avg=(tempAandP+tempComm+tempCoop+tempJandDM+tempQofW)/5;
        System.out.println("\nSave(and add) or change employees performance review:\n" +
                "1 - Save\n" +
                "2 - Change\n");
        choice = scan.nextInt();
        scan.nextLine();

        while (true) {
            if (choice == 1) {
                Review tempReview = new Review(tempQofW, tempAandP, tempComm, tempJandDM, tempCoop,avg); // creating temporary Review
                e.getPerfReviews().add(tempReview); // adding the created review to the employees performance review list
                System.out.println("\n" +
                        "The employees performance review has been succesfully created.\n");
                break;
            } else if (choice == 2) {
                addPerfReview(e); // recursion usage to change the previous performance review
                break;
            } else {
                System.out.println("Invalid Input! Please enter 1 or 2: ");
                choice = scan.nextInt();
                scan.nextLine();
            }
        }

    }

    public void updateEmployee() { // updates an Employee's records
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an Employee ID:");
        String updateID = scanner.nextLine();

        Employee emp = employees.get(updateID); // Get the employee object using their ID
        if (emp == null) {
            System.out.println("No employee found with ID " + updateID);
            return;
        }

        System.out.print("Enter employee name [" + emp.getEmpName() + "]: ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            emp.setEmpName(name);
        }

        System.out.print("Enter employee address [" + emp.getEmpAddress() + "]: ");
        String address = scanner.nextLine().trim();
        if (!address.isEmpty()) {
            emp.setEmpAddress(address);
        }

        System.out.print("Enter employee salary [" + emp.getEmpSalary() + "]: ");
        float salary = scanner.nextFloat();
        emp.setEmpSalary(salary);

        System.out.print("Enter employee position [" + getPosition() + "]: ");
        int position = scanner.nextInt();
        emp.setPosition(position);
        DataBase dataBase = new DataBase(); // initialize new database to update it
        dataBase.updateData(updateID); // updates the database with changed employee records
        System.out.println("Employee record updated successfully!");
    }

    public void jobPost() { // posts a new job/project announcement
        Scanner input = new Scanner(System.in);
        System.out.println("JOB POSTING");
        while (true) {
            System.out.println("Please enter a job name:");
            jobName = input.nextLine();
            System.out.println("Please enter the description of the job:");
            jobDesc = input.nextLine();
            System.out.println("Please enter the qualifications of the job:");
            jobQual = input.nextLine();
            System.out.println("Please enter the salary of the job:");
            jobSalary = input.nextInt();

            System.out.println("Job Informations \nJob Name: " + jobName +
                    "\nJob Description: " + jobDesc +
                    "\nJob Qualifications: " + jobQual +
                    "\nJob Salary: " + jobSalary);
            ArrayList arrayList = new ArrayList(); // initializing temporary array list for job/project announcements
            arrayList.add(jobName);
            arrayList.add(jobDesc);
            arrayList.add(jobQual);
            arrayList.add(jobSalary);

            System.out.println("\nPlease select the action you want to do:");
            System.out.println("1-Save the job \n2-Delete and recreate the job");
            int action = input.nextInt();
            if (action == 1) {
                jobs.put(jobName, arrayList); // add the announcement to the general announcements list
                System.out.println("The job saved.");
                break;
            } else if (action == 2) { // dummy function
                System.out.println("The job is recreating...");
                System.out.println();
                input.nextLine();
            } else {
                System.out.println("Invalid Action!");
                break;
            }
        }
    }

    public void displayEmployee() { // displays employees records
        for (String id : employees.keySet()) {
            employees.get(id).displayEmpRecs();
        }
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter Employee ID in order to add/view that employee's performance reviews: \n(Enter -1 for the previous Menu):");
            String temp = scan.nextLine();
            if (temp.equals("-1")) {
                System.out.println("\nDirecting back to previous menu...\n");
                break;
            } else if (employees.containsKey(temp)) { // checks if the ID exits in the employee records
                displayReviews(employees.get(temp)); // call to the function which displays the performance reviews
                break;
            } else {
                System.out.println("Invalid User Input!");
            }
        }
    }

    public void displayJobs() { // displays existing job/project announcements
        String[] jobApplications = {"1-Name:Ahmet,Position:Software,Experience:3 years",
                "2-Name:Ali,Position:HR,Experience:1 year",
                "3-Name:Mehmet,Position:Marketing,Experience:2 years",
                "4-Name:Hakan,Position:Product,Experience:4 years"};
        Scanner input = new Scanner(System.in);
        ArrayList jobList = new ArrayList();
        while (true) {
            System.out.println("Saved Jobs");
            for (String name : jobs.keySet()) {
                jobList.add(jobs.get(name));
            }
            for (int i = 0; i < jobList.size(); i++) {
                System.out.println(i + "-" + jobList.get(i));
            }
            if (jobList.size() == 0) {
                System.out.println("There are no saved jobs!");
                break;
            }

            System.out.println("Enter job number to view job applications:"); // display the job applications
            int jobApp = input.nextInt();
            System.out.println("Job Informations:" + jobList.get(jobApp));
            System.out.println("Job Applications:");
            for (int i = 0; i < jobApplications.length; i++) {
                System.out.println(jobApplications[i]);
            }
            System.out.println("Enter the number of the candidates you want to call for the interview using a comma.");
            input.nextLine();
            String jobCand = input.nextLine();
            String[] data = jobCand.split(","); // splits the selected application number.
            System.out.println("Accepted Applications:");
            for (int i = 0; i < data.length; i++) {
                int tmp = Integer.parseInt(data[i]);
                System.out.println(jobApplications[tmp - 1]);
            }
            break;
        }
    }
    public void requests(){ // all request can be seen and approve by Hr managers
        DataBase dataBase = new DataBase();
        while (true){
            dataBase.readPermission(); // reads All permission into db
            for (String Id : Worker.requestHash.keySet()) { // worker's who sends request and their request status
                Worker.requestHash.get(Id).displayEmpRecs();
                System.out.println("Request Approval: " + Worker.requestHash.get(Id).request);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the ID for accepting request / 0 for exit:");
            String tempId = scanner.next();
            Employee emp = Worker.requestHash.get(tempId); // Get the employee object using their ID
            if (emp == null) {
                System.out.println("No employee found with ID " + tempId);
                return;
            } else if (tempId.equals("0")) {
                System.out.println("quiting...");
                break;
            } else {
                Worker.requestHash.get(tempId).request = true; // approve request given ID
                dataBase.deletePermission();
                Worker.requestHash.remove(tempId);
            }
        }
    }
    public void reports(){ //displays reports about salaries or performance reviews
        Scanner input=new Scanner(System.in);
        double totalSalary=0;
        int counter=0;
        double max=0;
        double min=99999999;
        String name="";
        String name2="";
        System.out.println("1-Salary Reports\n2-Employee Performance Reports");
        System.out.println("Select the report you want to view:");
        int select=input.nextInt();
        if (select==1) {
            System.out.println("SALARY REPORTS");
            System.out.println("------------------------------------");
            for (String id : employees.keySet()) {
                System.out.println(employees.get(id).empName + "-" + employees.get(id).empSalary);
                totalSalary += employees.get(id).empSalary;
                counter++;
                if (max < employees.get(id).empSalary) { // Finds max salary
                    max = employees.get(id).empSalary;
                    name = employees.get(id).empName;
                }
                if (min > employees.get(id).empSalary) { // Finds min salary
                    min = employees.get(id).empSalary;
                    name2 = employees.get(id).empName;
                }
            }
            double avgSalary = totalSalary / counter;
            System.out.println("---------------------------------------");
            System.out.println("Total Salary of Employees: " + totalSalary);
            System.out.println("Employee with the highest salary: " + name + "-" + max);
            System.out.println("Employee with the lowest salary: " + name2 + "-" + min);
            System.out.println("Average Salary of Employees: " + avgSalary);
        }
        else if (select==2) {
            System.out.println("Enter the Employee ID to view the employee's performance report:"); // gets ID and calculate the employee's performance rating
            input.nextLine();
            String temp = input.nextLine();
            if (!employees.get(temp).getPerfReviews().isEmpty()) { // checks performance reviews of employee are empty or not
                for (int i = 0; i < employees.get(temp).getPerfReviews().size(); i++) {
                    System.out.println("Employee's average performance: " + employees.get(temp).getPerfReviews().get(i).getAverage() + "/4");
                    if (employees.get(temp).getPerfReviews().get(i).getAverage() > 2) {
                        System.out.println("Employee performance is above average.");
                    } else if (employees.get(temp).getPerfReviews().get(i).getAverage() == 2) {
                        System.out.println("Employee performance is average.");
                    } else {
                        System.out.println("Employee performance is below average.");
                    }
                }
            }
            else {
                System.out.println("The employee has no saved performance reports!");
            }
        }
        else {
            System.out.println("Invalid Input!");
        }
    }
    public void sendAnnouncements(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter an announcement:");
        String announcement=input.nextLine();
        if (announcements.contains(announcement)){
            System.out.println("This announcement already exists");
        }
        else {
            announcements.add(announcement);
        }
    }

    public void displayAppointments(){
        String tempDate,tempName;
        System.out.println("---APPOINTMENTS---");
        for (String[] a : this.appointments){
            tempDate = a[0];
            System.out.println(tempDate + " -- " + Manager.employees.get(a[1]).getEmpName() + ": " + Manager.employees.get(a[1]).position);
        }
    }
    public void checkDateForAppointments() throws ParseException {
        DataBase dataBase = new DataBase();

        String todaysDate;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        todaysDate = formatter.format(date);

        for (int i = 0; i < appointments.size() ; i++){
            String[] a = appointments.get(i);
            if (todaysDate.equals(a[0])){
                System.out.println("You Have a Appointment with " + Manager.employees.get(a[1]).getEmpName() + " today!!");
            }
            else if (new SimpleDateFormat("dd/MM/yyyy").parse(a[0]).before(new Date())){
                appointments.remove(i);
                dataBase.updateAppointment(this);
            }
        }
    }
}

