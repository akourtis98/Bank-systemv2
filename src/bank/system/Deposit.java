/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import DB.DBDeposit;
import static DB.DBDeposit.DepositTo;
import static DB.DBDeposit.setAmount;
import static DB.DBDisplayBalance.shutdown;
import static DB.DBEditUser.getDataFromDB;
import static bank.system.DeleteUser.checkIfNameExists;
import static bank.system.Main.clearConsole;
import static bank.system.MainMenu.getType;
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
public class Deposit {
    private static Scanner sc;
    private static String usrSlctd;

    /**
     * @param aUsrSlctd the usrSlctd to set
     */
    public static void setUsrSlctd(String aUsrSlctd) {
        usrSlctd = aUsrSlctd;
    }
    public Deposit() {}

    public static String getUsrSlctd(){
        return usrSlctd;
    }
    public static void depositTo() throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        System.out.println("select a user by typing their name");
        sc = new Scanner(System.in);
        getDataFromDB();
        String usrSlctd = sc.nextLine();
        checkWhichUSer(usrSlctd);
    }
        // select the user
    private static void checkWhichUSer(String usrSlctd) throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        if (checkIfNameExists(usrSlctd) && !(usrSlctd.equalsIgnoreCase("admin"))) {
            setUsrSlctd(usrSlctd);
            howMuch();
        } else {
            System.out.println("The user you entered doesnt exist");
            System.out.println("try again");
            clearConsole();
            depositTo();
        }
    }

    private static void howMuch() throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        System.out.println("how much\n");
        int c = sc.nextInt();
        if (DBDeposit.enoughBalance(c)){ //, 
            DepositTo(getCurrentname(),getUsrSlctd(), c);
            System.out.println("changes have taken effect");
            shutdown(getType());
        }else{
          System.out.println("Not enough money in account!");  
        }
    }
}