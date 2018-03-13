/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import DB.DBLoginCheck;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author alexkourtis11
 */
public class SubLogin {

    /**
     * @return the currentname
     */
    public static String getCurrentname() {
        return currentname;
    }

    /**
     * @param aCurrentname the currentname to set
     */
    public static void setCurrentname(String aCurrentname) {
        currentname = aCurrentname;
    }

    public SubLogin() {}

    private static String currentname = "";
    private static String[] credentials = new String[2];

    public static boolean start() throws SQLException,
        FileNotFoundException,
        UnsupportedEncodingException {
            return askForCredentials().equalsIgnoreCase(credentials[0]);
        }

    public static String askForCredentials() throws SQLException,
        FileNotFoundException,
        UnsupportedEncodingException {
            System.out.println("Please enter your credentials to log in as a user or an admin\n");
            System.out.println("username:");
            Scanner sc = new Scanner(System.in);
            credentials[0] = sc.nextLine();
            System.out.println("what is your password:");
            credentials[1] = sc.nextLine();
            setCurrentname((DBLoginCheck.checkLoginData(credentials)) ? currentname = credentials[0] : "false at sublogin.askforcreds()");
            return getCurrentname();
        }
}