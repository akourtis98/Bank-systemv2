/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DBDisplayBalance.shutdown;
import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.selectAllUsers;
import static bank.system.MainMenu.getType;
import static bank.system.MainMenu.mainmenu;
import static bank.system.SubLogin.getCurrentname;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author alexkourtis11
 */
public class DBDisplayAllForAdmin {

    public static void getDataFromDB() {
        try {
            DatabaseConnection.openConnection();
            System.out.println("Database connection successful! \n");

            Statement myStmnt = conn.createStatement();

            ResultSet myRs = myStmnt.executeQuery(selectAllUsers);
            String leftAlignFormat = "| %-9s | %-9s | %-9s | %-7s |%n";
            //System.out.println(myRs.getString("uname") + ", " + myRs.getString("first_name")+ ", " + myRs.getString("first_name")
            //         + ", " + myRs.getString("first_name")+ ", " + myRs.getString("first_name")+ ", " + myRs.getString("first_name"));
            System.out.format("+-----------+-----------+-----------+---------|%n");
            System.out.format("| username  | password  |  amount   |  type   |%n");
            System.out.format("+-----------+-----------+-----------+---------|%n");
            while (myRs.next()) {
                System.out.format(leftAlignFormat, myRs.getString("uname"), myRs.getString("pword"), myRs.getString("amount"), myRs.getString("type"));
            }
            System.out.format("+-----------+-----------+-----------+---------+%n");
            System.out.println("to go back to the main menu type 'menu', else the program will shut down. Thanks");
            Scanner scan = new Scanner(System.in);
            if (scan.nextLine().equalsIgnoreCase("menu")) mainmenu(getCurrentname(), getType());
                else shutdown(getType());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}