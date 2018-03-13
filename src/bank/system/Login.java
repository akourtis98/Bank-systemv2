/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql. * ;

/**
 *
 * @author alexkourtis11
 */
public class Login {

	private static String retString;
	public Login() {}

	public static boolean login() throws FileNotFoundException,
	UnsupportedEncodingException,
	SQLException {
		return SubLogin.start();
	}
}