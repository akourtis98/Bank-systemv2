/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.chngPword;
import static DB.DatabaseConnection.chngUname;
import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.insertedNameDataCheck;
import static DB.DatabaseConnection.myrs;
import static DB.DatabaseConnection.prprdstmnt;
import static DB.DatabaseConnection.selectOnlyUsernames;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alexkourtis11
 */
public class DBEditUser {

    public static void getDataFromDB() throws SQLException {
        try {
            DatabaseConnection.openConnection();
            Statement myStmnt = conn.createStatement();

            ResultSet myRs = myStmnt.executeQuery(selectOnlyUsernames);
            String leftAlignFormat = "| %-9s |%n";
            System.out.format("+-----------|%n");
            System.out.format("| username  |%n");
            System.out.format("+-----------|%n");
            while (myRs.next()) {
                System.out.format(leftAlignFormat, myRs.getString("uname"));
            }
            System.out.format("+-----------+%n");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static boolean checkDataFromDB(String insertedName) throws SQLException {
        // create a stmnt
        prprdstmnt = conn.prepareStatement(insertedNameDataCheck);
        prprdstmnt.setString(1, insertedName);
        myrs = prprdstmnt.executeQuery();
        boolean myrsHasNext = (myrs.next()) ? true : false;
        return myrsHasNext;
    }

    public static void chngUserNameInDB(String newInsertedName, String insertedName) throws SQLException {
        DatabaseConnection.openConnection();
        prprdstmnt = conn.prepareStatement(chngUname);
        prprdstmnt.setString(1, newInsertedName);
        prprdstmnt.setString(2, insertedName);
        prprdstmnt.executeUpdate();
    }

    public static void chngPwordInDB(String newInsertedName, String insertedName) throws SQLException {
        DatabaseConnection.openConnection();
        prprdstmnt = conn.prepareStatement(chngPword);
        prprdstmnt.setString(1, newInsertedName);
        prprdstmnt.setString(2, insertedName);
        prprdstmnt.executeUpdate();
    }
}