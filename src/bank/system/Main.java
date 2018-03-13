/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
/**
 *
 * @author alexkourtis11
 */
public class Main {
	public static Welcome Welcome;
	public static Login Login;
	public static MainMenu MainMenu;
	public static Main Main;

	public static void main(String[] args) throws SQLException,
	FileNotFoundException,
	UnsupportedEncodingException,
	IOException {
		System.out.println("Welcome to our bank! \n");
		Welcome.welcome();
	}
        
        public final static void clearConsole() {// InterruptedException
             System.out.print("\033[H\033[2J");
}
}