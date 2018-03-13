/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.enoughBalanceQuery;
import static DB.DatabaseConnection.insertInto;
import static DB.DatabaseConnection.removeFrom;
import static DB.DatabaseConnection.prprdstmnt;
import static bank.system.SubLogin.getCurrentname;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexkourtis11
 */
public class DBDeposit {
    private static ResultSet myrs;
    private static int amount;

    public static boolean enoughBalance(int money){
         try {
            prprdstmnt = conn.prepareStatement(enoughBalanceQuery);
            prprdstmnt.setString(1, getCurrentname());
            prprdstmnt.setInt(2, money);
            myrs = prprdstmnt.executeQuery();
            boolean myrsHasNext = (myrs.next()) ? true : false;
            return myrsHasNext;
        } catch (Exception exc) {   
            return false;
        }       
    }
    /// method depositTo(String userfrom, String userTo, float amountF)
    public static void DepositTo(String userFrom, String userTo, int amount) {
        try {
            insertTo(userTo, amount);
            removeFrom(userFrom, amount);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    protected static void insertTo(String userTo, int amount) throws SQLException {
        try {
            prprdstmnt = conn.prepareStatement(insertInto);
            prprdstmnt.setInt(1, amount);
            prprdstmnt.setString(2, userTo);
            prprdstmnt.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("2nd exception got caught m8");
        }
    }

    protected static void removeFrom(String userFrom, int amount) {
        try {
            prprdstmnt = conn.prepareStatement(removeFrom);
            prprdstmnt.setInt(1, amount);
            prprdstmnt.setString(2, userFrom);
            prprdstmnt.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("44nd exception got caught m8");
        }
    }

    /**
     * @return the amount
     */
    public static int getAmount() {
        return amount;
    }

    /**
     * @param aAmount the amount to set
     */
    public static void setAmount(int aAmount) {
        amount = aAmount;
    }

}