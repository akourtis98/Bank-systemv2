/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import DB.DBCreateNewUser;
import static DB.DBDisplayBalance.shutdown;
import DB.DatabaseConnection;
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
public class CreateNewUser {

    private static String[] credentials = new String[2];


    public static void start() throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        System.out.println("You are in creating new user\n");
        if (askForCredentials()) {
            amountOfferMsg();
        } else {
            System.out.println("please enter proper values...");
            start();
        }
    }
    public static boolean askForCredentials() throws SQLException {
        System.out.println("what is the username\n");
        Scanner sc = new Scanner(System.in);
        credentials[0] = sc.nextLine();
        System.out.println("what is the password\n");
        credentials[1] = sc.nextLine();
        if (credentials[0].equalsIgnoreCase("") ||
                (credentials[1].equalsIgnoreCase(""))){
            System.out.println("gotcha"); 
            return false;
        }else if (DBCreateNewUser.create(credentials[0], credentials[1]))
            return true;
        else
            return false;
    }
    

    public static void amountOfferMsg() throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        System.out.println("congrats for signing up!\n" + "as a present from the bank to you, we grant you $500.");
        shutdown(getType());
    }
}