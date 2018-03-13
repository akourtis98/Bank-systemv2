/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import bank.system.Login;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alexkourtis11
 */
public final class DatabaseConnection {

    private static final String JDBC = "jdbc:mysql://localhost:3306/databasexyz?useSSL=false";
    private static final String username = "root";
    private static final String password = "x";
    protected static Connection conn;
    protected static PreparedStatement prprdstmnt;
    protected static ResultSet myrs;
    protected static String selectBalance = "select uname, amount from  user where uname = ?";
    protected static String selectAllUsers = "select * from  user";
    protected static String selectOnlyUsernames = "select uname from user where type = 'user'";
    protected static String selectAllTrans = "select * from  transcations";
    protected static String enoughBalanceQuery = "SELECT uname from user where uname = ? and amount > ? ";
    protected static String enoughBalanceQueryWithdraw = "SELECT uname from user where uname = ? and amount > ? ";
    protected static String insertInto = "update user set amount = amount + ? where uname = ?";
    protected static String removeFrom = "update user set amount = amount - ? where uname = ?";
    protected static String insertAndRemoveD = "update user set amount = amount + ?, cash = cash - ? where uname = ?";
    protected static String insertAndRemoveW = "update user set amount = amount - ?, cash = cash + ? where uname = ?";
    protected static String createUser = "INSERT INTO user (uname, pword, amount, type) VALUES (?, ?, 500, \"user\")";
    protected static String loginUserDataCheck = "SELECT uname, pword from user where uname = ? and pword = ?";
    protected static String insertedNameDataCheck = "SELECT uname from user where uname = ? ";
    protected static String loginDataTypeCheck = "SELECT type from user where uname = ?";
    protected static String chngUname = "UPDATE user set uname = ? where uname = ?";
    protected static String chngPword = "UPDATE user set pword = ? where uname = ?"; 
    protected static String deleteFromDB = " delete from user where uname = ? and type = 'user' ";
    protected static String insertTransaction = "INSERT INTO transcations (fromm, tom, action, amount, date) VALUES (?, ?, ?, ?, ?)";
    
    public DatabaseConnection() {}

    //    public static void main(String[] args) throws SQLException, FileNotFoundException, UnsupportedEncodingException{
    //            openConnection();
    //            Login.login();
    //            closeConnection();
    //    }

    public static void openConnection() throws SQLException {
        conn = DriverManager.getConnection(JDBC, username, password);
    }


    protected static void closeConnection() throws SQLException {
        conn.close();
    }
}