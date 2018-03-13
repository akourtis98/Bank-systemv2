/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DatabaseConnection.conn;
import static DB.DatabaseConnection.selectAllTrans;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;

/**
 *
 * @author alexkourtis11
 */
public class TransactionsLogFile {
    private static DateTimeFormatter dtf;
    private static LocalDateTime localDateTime;
    private static StringBuilder data = new StringBuilder();


    public static void getTransactions() throws FileNotFoundException, UnsupportedEncodingException {

        Statement myStmnt = null;
        ResultSet myRs = null;

        try {
            DatabaseConnection.openConnection();
            System.out.println("Getting data from table... please wait \n");
            // create a stmnt
            myStmnt = conn.createStatement();

            //exec query
            myRs = myStmnt.executeQuery(selectAllTrans);
            while (myRs.next()) {
                data.append("On " + myRs.getString("date") + " " + myRs.getString("fromm") + " " + myRs.getString("action") + " " + myRs.getString("adverb") +
                    " " + myRs.getString("tom") + " " + myRs.getString("amount"));
                data.append("\n");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("error");
        }
        System.out.println("data: " + "\n" + data);
        printOutInTxtFile();
    }


    private static void printOutInTxtFile() throws FileNotFoundException, UnsupportedEncodingException {
        getCurrentDate();

        PrintWriter writer = new PrintWriter("Transactions logs/data-for-" + dtf.format(localDateTime) + ".txt", "UTF-8");
        writer.println(data);
        writer.close();
    }

    private static void getCurrentDate() {
        dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy' at 'HH:mm");
        localDateTime = localDateTime.now();
    }
}