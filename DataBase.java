

import java.io.*;

class DataBase { // txt databse
    public void readData() { // function that reads data from the txt to the employee hashmap
        String tempName, tempPassword, tempAddress, tempId, tempStartDate;
        float tempSalary;                                            // declaring Temporary attributes
        int tempPosition;
        try {    //read txt
            BufferedReader reader = new BufferedReader(new FileReader("Hr_data.txt"));
            String line = "";
            String[] row;
            reader.readLine(); //skipping first line because first line is name of the attributes.

            while ((line = reader.readLine()) != null) { // when read line is null it breaks the while loop
                row = line.split(","); // splitting columns
                tempId = row[0];
                tempPassword = row[1];
                tempPosition = Integer.parseInt(row[2]);
                tempName = row[3];
                tempAddress = row[4];
                tempSalary = Float.parseFloat(row[5]);
                tempStartDate = row[6];

                Employee employee = Employee.createEmployee(tempPosition); // creating employee class using with position (if it is HR then it creates manager)
                employee.setEmpID(tempId);
                employee.setEmpPass(tempPassword);
                employee.setPosition(tempPosition);
                employee.setEmpName(tempName);          // setting attributes
                employee.setEmpAddress(tempAddress);
                employee.setEmpSalary(tempSalary);
                employee.setStartDate(tempStartDate);

                Manager.employees.put(tempId, employee);     // put our employee class into hashmap
            }
        } catch (IOException e) {
            System.out.println("Error reading file: ");
            e.printStackTrace();
        }
    }

    public void writeData(Employee employee) { // writes data into the txt file of the employees
        File file = new File("Hr_data.txt"); // creating our temporary database path.
        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(writer)) { // write data's
            if (file.length() == 0) { // if File is empty it creates first row for attributes name
                bw.write("ID,Password,Position,Name,Address,Salary,StartDate"); // attributes name
            }
            bw.newLine(); // new line for new data rows
            bw.write(employee.getEmpID() + "," + employee.getEmpPass() + "," + employee.getPosition() + "," + employee.getEmpName() + "," + employee.getEmpAddress() + "," + employee.getEmpSalary() + "," + employee.getStartDate()); //writing our necessary data's for txt files
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void updateData(String Id) { // updates the data at employee Hashmap and txt file
        String tempId;      // declaring Temporary attributes
        File file = new File("Hr_data.txt");
        try {    //read txt
            BufferedReader reader = new BufferedReader(new FileReader("Hr_data.txt"));
            String line = "";
            String[] row;
            reader.readLine(); //skipping first line because first line is name of the attributes.

            while ((line = reader.readLine()) != null) { // when read line is null it breaks the while loop
                row = line.split(","); // splitting columns
                tempId = row[0];
                if (tempId.equals(Id)) {
                    new FileWriter("Hr_data.txt", false).close();
                    for (String s : Manager.employees.keySet()) {
                        writeData(Manager.employees.get(s));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: ");
            e.printStackTrace();
        }
    }
    public void readPermission(){ // It reads Id and Request pairs
        String tempId;
        boolean tempRequest;
        try {    //read txt
            BufferedReader reader = new BufferedReader(new FileReader("PermissionData.txt"));
            String line = "";
            String[] row;
            reader.readLine(); //skipping first line because first line is name of the attributes.

            while ((line = reader.readLine()) != null) { // when read line is null it breaks the while loop
                row = line.split(","); // splitting columns
                tempId = row[0];
                tempRequest = Boolean.parseBoolean(row[1]);

                Manager.employees.get(tempId).request = tempRequest; // Assigns request according to their ID
                Worker.requestHash.put(tempId,Manager.employees.get(tempId));// It puts Id and employee

            }
        } catch (IOException e) {
            System.out.println("Error reading file: ");
            e.printStackTrace();
        }
    }
    public void writePermission(Employee employee) { // writes data into the txt file of the employees
        File file = new File("PermissionData.txt"); // creating our temporary database path.
        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(writer)) { // write data's
            if (file.length() == 0) { // if File is empty it creates first row for attributes name
                bw.write("ID,Request"); // attributes name
            }
            bw.newLine(); // new line for new data rows
            bw.write(employee.getEmpID() + "," + employee.request); //writing request's into the database
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    public void deletePermission(){
        try {    //read txt
            BufferedReader reader = new BufferedReader(new FileReader("PermissionData.txt"));
            String line = "";
            String[] row;
            reader.readLine(); //skipping first line because first line is name of the attributes.

            while ((line = reader.readLine()) != null) { // when read line is null it breaks the while loop
                row = line.split(","); // splitting columns
                new FileWriter("PermissionData.txt", false).close();
                for (String s : Worker.requestHash.keySet()) {
                    writePermission(Worker.requestHash.get(s)); // updates requests
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: ");
            e.printStackTrace();
        }
    }
    public void readAppointment(){
        String tempManagerId;
        String tempDate;
        String tempWorkerId;
        try {    //read txt
            BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"));
            String line = "";
            String[] row;
            reader.readLine(); //skipping first line because first line is name of the attributes.

            while ((line = reader.readLine()) != null) { // when read line is null it breaks the while loop
                row = line.split(","); // splitting columns
                tempManagerId = row[0];
                tempDate = row[1];
                tempWorkerId = row[2];

                String[] array = new String[2];
                array[0] = tempDate;
                array[1] = tempWorkerId;
                Manager.employees.get(tempManagerId).getAppointments().add(array);

            }
        } catch (IOException e) {
            System.out.println("Error reading file: ");
            e.printStackTrace();
        }
    }
    public void writeAppointment(Employee manager,Employee worker,String AppointDate){
        File file = new File("Appointment.txt"); // creating our temporary database path.
        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(writer)) { // write data's
            if (file.length() == 0) { // if File is empty it creates first row for attributes name
                bw.write("Manager,AppointmentDate,Worker"); // attributes name
            }
            bw.newLine(); // new line for new data rows
            bw.write(manager.getEmpID() + "," + AppointDate + "," + worker.empID); //writing request's into the database
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    public void updateAppointment(Employee manager){
        try {    //read txt
            BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"));
            String line = "";
            String[] row;
            reader.readLine(); //skipping first line because first line is name of the attributes.

            while ((line = reader.readLine()) != null) { // when read line is null it breaks the while loop
                row = line.split(","); // splitting columns
                new FileWriter("Appointment.txt", false).close();
                for (String Id : Manager.employees.keySet()){
                    for (String[] s : Manager.employees.get(Id).getAppointments()){
                        writeAppointment(Manager.employees.get(Id),Manager.employees.get(s[1]),s[0]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: ");
            e.printStackTrace();
        }
    }
}
