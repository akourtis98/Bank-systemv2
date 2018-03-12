/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.insertInto;
import static DB.DatabaseConnection.removeFrom;
import static DB.DatabaseConnection.prprdstmnt;
import java.sql.SQLException;

/**
 *
 * @author alexkourtis11
 */
public class DBDeposit {
    
     /// method depositTo(String userfrom, String userTo, float amountF)
         protected static void DepositTo(String userFrom, String userTo, int amount){
             try{
                 insertTo(userTo, amount);
                 removeFrom(userFrom, amount);
             }catch(Exception exc){
			exc.printStackTrace();
                        System.out.println("exception caught m8");
		}
               
         }
         
         protected static void insertTo(String userTo, int amount) throws SQLException{
              try{
                 prprdstmnt = conn.prepareStatement(insertInto);
                 prprdstmnt.setInt(1, amount);
                 prprdstmnt.setString(2, userTo);
                 prprdstmnt.executeUpdate();
             }catch(Exception exc){
			exc.printStackTrace();
                        System.out.println("2nd exception got caught m8");
		}
         }
         
         protected static void removeFrom(String userFrom, int amount){
                try{
                 prprdstmnt = conn.prepareStatement(removeFrom);
                 prprdstmnt.setInt(1, amount);
                 prprdstmnt.setString(2, userFrom);
                 prprdstmnt.executeUpdate();
             }catch(Exception exc){
			exc.printStackTrace();
                        System.out.println("44nd exception got caught m8");
		}
         }
         
}
