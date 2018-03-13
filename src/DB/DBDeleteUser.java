/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.deleteFromDB;
import static DB.DatabaseConnection.myrs;
import static DB.DatabaseConnection.prprdstmnt;
import java.sql.SQLException;

/**
 *
 * @author alexkourtis11
 */
public class DBDeleteUser {


    public static boolean deleteUSer(String insertedName) throws SQLException {
        // create a stmnt
        prprdstmnt = conn.prepareStatement(deleteFromDB);
        prprdstmnt.setString(1, insertedName);
        prprdstmnt.executeUpdate();
        boolean myrsHasNext = (myrs.next()) ? true : false;
        return myrsHasNext;
    }
}