/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import static DB.DBDeleteUser.deleteUSer;
import static DB.DBDisplayBalance.shutdown;
import DB.DBEditUser;
import static bank.system.MainMenu.getType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author alexkourtis11
 */
public class DeleteUser {

    private static String insertedName;

    public DeleteUser() {}

    // method to show all users
    public static void showUsersToDelete() throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        DBEditUser.getDataFromDB();
        insertUserName();
    }

    // select the user
    public static void insertUserName() throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        Scanner sc = new Scanner(System.in);
        insertedName = sc.nextLine();
        if (checkIfNameExists(insertedName) && !(insertedName.equalsIgnoreCase("admin"))) {
            System.out.println("Are you sure you want to delete this user?");
            System.out.println("type 'yes' or 'no'");
            sc = new Scanner(System.in);
            String ch = sc.nextLine();
            if (ch.equalsIgnoreCase("yes")) {
                deleteUSer(insertedName);
            } else {
                shutdown(getType());
            }
        } else {
            System.out.println("The user you entered doesnt exist");
            insertUserName();
        }
    }

    // check if user exists
    public static boolean checkIfNameExists(String insertedName) throws SQLException {
        if (DBEditUser.checkDataFromDB(insertedName))
            return true;
        else
            return false;
    }
}