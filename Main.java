import java.io.*;
import java.text.ParseException;
import java.util.*;


public class Main { // main function


    public static void main(String[] args) throws ParseException {
        DataBase dataBase = new DataBase(); // initializing new Database
        dataBase.readData(); // reads all the data's from the txt to employee Hashmap
        dataBase.readAppointment();
        Login login = new Login();
        login.LoginPage();
    }
}
