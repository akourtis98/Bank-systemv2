/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.loginDataTypeCheck;
import static DB.DatabaseConnection.myrs;
import static DB.DatabaseConnection.prprdstmnt;
import java.sql.SQLException;

/**
 *
 * @author alexkourtis11
 */
public class DBCheckTypeOfUser {

    private static String type;
    private static boolean typeBoolean;
    public static boolean checkLoginType(String currentname) throws SQLException {

        DatabaseConnection.openConnection();
        // create a stmnt
        prprdstmnt = conn.prepareStatement(loginDataTypeCheck);
        prprdstmnt.setString(1, currentname);
        myrs = prprdstmnt.executeQuery();
        while (myrs.next()) {
            type = myrs.getString("type");
        }
        // boolean myrsHasNext = (myrs.next()) ? true : false;
        typeBoolean = type.equalsIgnoreCase("user") ? true : false;
        return typeBoolean;
    }
}