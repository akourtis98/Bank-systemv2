/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.myrs;
import static DB.DatabaseConnection.prprdstmnt;
import static DB.DatabaseConnection.selectBalance;
import static bank.system.MainMenu.getType;
import static bank.system.MainMenu.mainmenu;
import static bank.system.SubLogin.getCurrentname;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author alexkourtis11
 */
public class DBDisplayBalance {

    public static void getBalanceForCurrentUser(String currentname) {
        try {
            DatabaseConnection.openConnection();
            // create a stmnt
            prprdstmnt = conn.prepareStatement(selectBalance);
            //exec query
            prprdstmnt.setString(1, currentname);
            myrs = prprdstmnt.executeQuery();

            String leftAlignFormat = "| %-9s | %-9s |%n";
            System.out.format("+-----------+-----------+%n");
            System.out.format("| username  | balance   |%n");
            System.out.format("+-----------+-----------|%n");
            while (myrs.next()) {
                System.out.format(leftAlignFormat, myrs.getString("uname"), myrs.getString("amount"));
            }
            System.out.format("+-----------+-----------+%n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void shutdown(String type) throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        System.out.println("to go back to the main menu type 'menu', else the program will shut down. Thanks");
        Scanner scan = new Scanner(System.in);
        if (scan.nextLine().equalsIgnoreCase("menu")) mainmenu(getCurrentname(), getType());
        else System.exit(0);
    }
}