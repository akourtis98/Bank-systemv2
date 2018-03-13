/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.enoughBalanceQueryWithdraw;
import static DB.DatabaseConnection.insertInto;
import static DB.DatabaseConnection.myrs;
import static DB.DatabaseConnection.prprdstmnt;
import static DB.DatabaseConnection.removeFrom;
import static bank.system.Withdraw.getUsrSlctd;
import java.sql.SQLException;

/**
 *
 * @author alexkourtis11
 */
public class DBWithdraw {

    /// method depositTo(String userfrom, String userTo, float amountF)
    public static void withdrawFrom(String userFrom, String userTo, int amount) {
        try {
            insertTo(userTo, amount);
            removeFrom(userFrom, amount);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
    
      public static boolean enoughBalanceWithdraw( int money){
         try {
            prprdstmnt = conn.prepareStatement(enoughBalanceQueryWithdraw);
            prprdstmnt.setString(1, getUsrSlctd());
            prprdstmnt.setInt(2, money);
            myrs = prprdstmnt.executeQuery();
            boolean myrsHasNext = (myrs.next()) ? true : false;
            return myrsHasNext;
        } catch (Exception exc) {   
            return false;
        }       
    }
    
    private static void insertTo(String userTo, int amount) throws SQLException {
        try {
            prprdstmnt = conn.prepareStatement(insertInto);
            prprdstmnt.setInt(1, amount);
            prprdstmnt.setString(2, userTo);
            prprdstmnt.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    protected static void removeFrom(String userFrom, int cashamount) {
        try {
            prprdstmnt = conn.prepareStatement(removeFrom);
            prprdstmnt.setInt(1, cashamount);
            prprdstmnt.setString(2, userFrom);
            prprdstmnt.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}