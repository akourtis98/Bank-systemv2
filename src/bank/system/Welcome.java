/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import DB.DBCheckTypeOfUser;
import static bank.system.Main.Login;
import static bank.system.Main.clearConsole;
import static bank.system.MainMenu.mainmenu;
import static bank.system.SubLogin.getCurrentname;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 *
 * @author alexkourtis11
 */
public class Welcome {
    
    private static int tries;

    public Welcome() {}

    protected static void welcome() throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        for (tries = 3; tries >= 0; tries--) {
            
            if (Login.login()) {
                if (DBCheckTypeOfUser.checkLoginType(getCurrentname()))
                    mainmenu(getCurrentname(), "user");
                else
                    mainmenu(getCurrentname(), "admin");
            }else{
                clearConsole();
                System.out.println("please enter correct credentials\nyou have " + tries + " tries remaining");
            }
        }
        System.out.println("You are locked out!");
        System.exit(0);
    }
}