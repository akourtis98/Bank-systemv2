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
public class SubLogin {
    
       private static String[] credentials = new String[2];
      // public static void main(String[] args) {
       //start();
        //}
       public static void start(){
           System.out.println("Please enter your credentials\n");
        if (askForCredentials()){
            loginMsg();
        }
        else{
            System.out.println("please check your info and input appropriate values");
            askForCredentials();
        }
       }
       public static boolean askForCredentials(){
            System.out.println("what is your username\n");
            Scanner sc = new Scanner(System.in);
            credentials[0] = sc.nextLine();
            System.out.println("what is your password\n");
            credentials[1] = sc.nextLine();
            for(String credential : credentials){
                System.out.println(credential+"\n");
            } 
            //callLoginCheckMethod 
            return true;
       } 
    
       //confirm and call DBCreateNewUser.create(cred[0], cred[1]);();
       public static void loginMsg(){
         System.out.println("congarts for signing in as user!\n");  
       }
}
