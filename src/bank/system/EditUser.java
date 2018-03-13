/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import DB.DBDisplayBalance;
import DB.DBEditUser;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alexkourtis11
 */
public class EditUser {

    private static String insertedName;

    public EditUser() {}

    // method to show all users
    public static void showUsersToEdit() throws SQLException {
        DBEditUser.getDataFromDB();
        insertUserName();
    }

    // select the user
    public static void insertUserName() throws SQLException {
        Scanner sc = new Scanner(System.in);
        insertedName = sc.nextLine();
        if (checkIfNameExists(insertedName) && !(insertedName.equalsIgnoreCase("admin"))) {
            fieldEdit(insertedName);
        } else {
            System.out.println("The user you entered doesnt exist");
            System.out.println("try again");
            insertUserName();
        }
    }

    // check if user exists
    public static boolean checkIfNameExists(String insertedName) throws SQLException  {
        if (DBEditUser.checkDataFromDB(insertedName))
            return true;
        else
            System.out.println("asfas");
            return false;
    }


    public static void fieldEdit(String insertedName) throws SQLException {
        DBDisplayBalance.getBalanceForCurrentUser(insertedName);
        System.out.println("to change the username press '1'\nto change the password press '2'");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt() == 1 ? 1 : 2;
            switch (choice) {
                case 1:
                    System.out.println("what would you like to be their new username?");
                    sc = new Scanner(System.in);
                    String newInsertedName = sc.nextLine();
                    DBEditUser.chngUserNameInDB(newInsertedName, insertedName);
                    System.out.println("Changes have taken effect successfully");
                    break;
                case 2:
                    System.out.println("what would you like to be their new password?");
                    sc = new Scanner(System.in);
                    newInsertedName = sc.nextLine();
                    DBEditUser.chngPwordInDB(newInsertedName, insertedName);
                    System.out.println("Changes have taken effect successfully");
                    break;
                default:
                    System.out.println("please try again");
            }
        } catch (InputMismatchException exc) {
            System.out.println("enter valid options!");
            System.out.println("ente username");
            insertUserName();
        }
    }
}