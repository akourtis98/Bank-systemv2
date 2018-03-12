/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.loginUserDataCheck;
import static DB.DatabaseConnection.myrs;
import static DB.DatabaseConnection.prprdstmnt;
import java.sql.SQLException;

/**
 * 
 * @author alexkourtis11
 */
public class DBLoginCheck {
    
    public static boolean checkLoginData() throws SQLException {
         	
                        DatabaseConnection.openConnection();
			// create a stmnt
			prprdstmnt = conn.prepareStatement(loginUserDataCheck);
			prprdstmnt.setString(1, "alex");
                        prprdstmnt.setString(2, "pword");
                        myrs = prprdstmnt.executeQuery();
			if(myrs.next()){
				System.out.println(myrs.getString("uname") + ", " + myrs.getString("pword"));
                                return true;
			}else{
                                return false;
                                }
                        }
    }    

