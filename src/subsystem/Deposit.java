/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsystem;

import bank.system.Main;
import java.util.Scanner;

/**
 *
 * @author alexkourtis11
 */
public class Deposit {
    private static Scanner sc;
    public Deposit(){  
    }
    
        public static void depositTo(){
            System.out.println("you are inside the deposit\n");
            System.out.println("select user to deposit $$ to\n or select ursself");
            sc = new Scanner(System.in);
            String c = sc.nextLine();
            System.out.println("You deposited to: " + c + "\n");
            howMuch();
    }
    
        private static void howMuch(){
            System.out.println("how much\n");
            String c = sc.nextLine();
            System.out.println("you deposited: $"
                        + c + " to user\n");
            validityCheck();
    }
       
        private static void validityCheck(){
            System.out.println("Your request is being validated...");
            //wait method
            confirm();
    }
    
       private static void confirm(){
            System.out.println("The transaction has been confrimed\n Please go to main menu to print out a trasnaction log\n thanks");
            //wait method
            mainmenu();
    }
       private static void mainmenu(){
        System.out.println("Go to main menu? \n or exit?");
        sc = new Scanner(System.in);
        int c = sc.nextInt();
        switch (c){
            case 1:
                Main.MainMenu.mainmenu();
                break;
            case 2:
                System.out.println("Goodbye");
                //wait method
                System.exit(0);
                break;
        }
    } 
}
