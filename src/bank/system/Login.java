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
import subsystem.SubLogin;

/**
 *
 * @author alexkourtis11
 */
public class Login {
    
    public Login() {
    }
       public static void login() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
       
        System.out.println("Passed throguh login\n");
        //SubLogin.start();   
         //openConnection();
        if( DBLoginCheck.checkLoginData()){
            System.out.println("CORRECT INFO");
           //        Main.MainMenu.mainmenu();
        }else{
            System.out.println("there is no match... please try gaain with correct credentials");
        }
    }
}