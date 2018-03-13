/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import DB.DBDisplayAllForAdmin;
import DB.DBDisplayBalance;
import static DB.DBDisplayBalance.shutdown;
import DB.DatabaseConnection;
import DB.TransactionsLogFile;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static bank.system.DeleteUser.showUsersToDelete;
import static bank.system.Main.clearConsole;
import static bank.system.SubLogin.getCurrentname;
import static bank.system.SubLogin.setCurrentname;
import java.io.IOException;
/**
 *
 * @author alexkourtis11
 */
public class MainMenu {
    public static Scanner sc;
    protected static Deposit Deposit;
    protected static Withdraw Withdraw;
    public static String[] options;
    private static String type;

 
    public static String getType() {
        return type;
    }

    public static void setType(String aType) {
        type = aType;
    }
    public MainMenu() {}

    public static void mainmenu(String currentname, String type) throws SQLException,
        FileNotFoundException,
        UnsupportedEncodingException,
        IOException {
        clearConsole();
        DatabaseConnection.openConnection();
            setType(type);
            try {
                int i = 1;
                System.out.println("Welcome back " + currentname + " " );

                //display menu
                for (String option: setDisplayOptions(type)) {
                    System.out.println("[" + i + "]" + option);
                    i++;
                }

                // load it
                loadMenu(type);

            } catch (InputMismatchException exc) {
                System.out.println("Please enter appropriate input such as: '1', '2', etc...");
                mainmenu(currentname, type);
            }
        }
    
     private static String[] setDisplayOptions(String type) {
        if (type.equalsIgnoreCase("user")) return options = new String[] {
            "Display balance for " + getCurrentname(),
            "Deposit",
            "Withdraw",
            "Log out",
            "Exit"
        };
        else if (type.equalsIgnoreCase("admin")) return options = new String[] {
            "Display all data from all users ",
            "Show balance of admin",
            "Deposit money to user",
            "Edit user",
            "Delete user",
            "Create new user",
            "Write transaction log",
            "Log out",
            "Exit"
        };
        else{
            System.exit(0);
            return options = new String[] {
            "ends here"};
        }
    }
    private static void loadMenu(String type) throws SQLException,
        FileNotFoundException,
        UnsupportedEncodingException,
        IOException {

            if (type.equalsIgnoreCase("user")) {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("choose a number: ");
                    int c = sc.nextInt();
                    switch (c) {
                        case 1:
                            DBDisplayBalance.getBalanceForCurrentUser(getCurrentname());
                            shutdown(getType());
                            break;
                        case 2:
                            Deposit.depositTo();
                            shutdown(getType());
                            break;
                        case 3:
                            Withdraw.withdrawFrom();
                            shutdown(getType());
                            break;
                        case 5:
                            System.out.println("Goodbye");
                            //wait method
                            System.exit(0);
                            break;
                        case 4:
                            System.out.println("log out");
                            setCurrentname(null);
                            type = null;
                            Welcome.welcome();
                            System.exit(0);
                            break;
                    }
                } catch (InputMismatchException exc) {
                    System.out.println("Please enter appropriate input such as: '1', '2', etc...");
                    mainmenu(getCurrentname(), type);
                }
            } else {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("choose a number: ");
                    int c = sc.nextInt();
                    switch (c) {
                        case 1:
                            DBDisplayAllForAdmin.getDataFromDB();
                            shutdown(getType());
                            break;
                        case 2:
                            DBDisplayBalance.getBalanceForCurrentUser(getCurrentname());
                            shutdown(getType());
                            break;
                        case 4:
                            EditUser.showUsersToEdit();
                            shutdown(getType());
                            break;
                        case 5:
                            showUsersToDelete();
                            shutdown(getType());
                            break;
                        case 6:
                            CreateNewUser.start();
                            break;
                        case 7:
                            TransactionsLogFile.getTransactions();
                            System.out.println("A transaction log has been written to a text file in the src foolder of this project");
                            shutdown(getType());
                            break;
                        case 3:
                            Deposit.depositTo();
                            shutdown(getType());
                            break;
                        case 9:
                            System.out.println("Goodbye");
                            //wait method
                            System.exit(0);
                            break;
                        case 8:
                            System.out.println("log out");
                            setCurrentname(null);
                            type = null;
                            Welcome.welcome();
                            System.exit(0);
                            break;
                    }
                } catch (InputMismatchException exc) {
                    System.out.println("Please enter appropriate input such as: '1', '2', etc...");
                    mainmenu(getCurrentname(), type);
                }
            }
        }
}