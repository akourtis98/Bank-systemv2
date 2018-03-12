/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsystem;

import java.util.Scanner;

/**
 *
 * @author alexkourtis11
 */
public class CreateNewUser {
       private static String[] credentials = new String[2];
      // public static void main(String[] args) {
       //start();
        //}
       public static void start(){
           System.out.println("You are in creating new user\n");
        if (askForCredentials()){
            amountOfferMsg();
        }
        else{
            System.out.println("please check your info and input appropriate values");
            askForCredentials();
        }
       }
       public static boolean askForCredentials(){
            System.out.println("what is the username\n");
            Scanner sc = new Scanner(System.in);
            credentials[0] = sc.nextLine();
            System.out.println("what is the password\n");
            credentials[1] = sc.nextLine();
            for(String credential : credentials){
                System.out.println(credential+"\n");
            } 
            return true;
       } 
    
       //confirm and call DBCreateNewUser.create(cred[0], cred[1]);();
       public static void amountOfferMsg(){
         System.out.println("congarts for signing up!\n" + "as a present from the bank to you, we grant you $500. (tha pigeni se amount)\n");  
         System.out.println("pigene main menu || h an thelis na kanis login os o neos xristis pigene epelexe pali ogin apto main menu\n");  
       }
       
    // "
    // pigene main menu )an thelis na kanis login os o neos xristis pigene epelexe pali ogin apto main menu
    
}
