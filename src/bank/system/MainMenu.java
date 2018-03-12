/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;


import DB.TransactionsLogFile;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import subsystem.CreateNewUser;
import subsystem.Withdraw;
import subsystem.Deposit;
import subsystem.Help;
/**
 *
 * @author alexkourtis11
 */
public class MainMenu {
    public static Scanner sc;
    protected static Deposit Deposit;
    protected static Withdraw Withdraw;
    public MainMenu(){
        
    }
    public static void mainmenu(){
        System.out.println("passed throgh main menu");
        sc = new Scanner(System.in);
        int c = sc.nextInt();
        switch (c){
            case 1:
                Deposit.depositTo();
                break;
            case 2:
                Withdraw.withdrawFrom();
                break;
            case 3:
                CreateNewUser.start();
                break;
            case 4:
        {
            try {
                TransactionsLogFile.getTransactions();
            } catch (FileNotFoundException ex) {
                System.out.println("1");
            } catch (UnsupportedEncodingException ex) {
                 System.out.println("2");
            }
        }
                System.out.println("A transaction log has been written to a text file in the src foolder of this project");
                break;
            case 5:
                Help.getHelpUser();
                break;
            case 6:
                System.out.println("Goodbye");
                //wait method
                System.exit(0);
                break;
            default:
                System.out.println("clicked default");
                break;
        }
    }
}
