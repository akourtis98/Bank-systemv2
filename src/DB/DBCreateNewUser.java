/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.prprdstmnt;
import java.sql.SQLException;
import static DB.DatabaseConnection.createUser;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author alexkourtis11
 */
public class DBCreateNewUser {

    public static boolean create(String uname, String pword) {
        try {
            prprdstmnt = conn.prepareStatement(createUser);
            prprdstmnt.setString(1, uname);
            prprdstmnt.setString(2, pword);
            prprdstmnt.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicates are not allowed!\nTry again!");
            return false;
        } catch (SQLException e) {
            System.out.println("connection error");
            return false;
        }
    }
}