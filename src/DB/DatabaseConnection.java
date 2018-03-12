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
    protected static String selectAllTrans = "select * from  transcations";
    protected static String insertInto = "update user set amount = amount + ? where uname = ? ";
    protected static String removeFrom = "update user set amount = amount - ? where uname = ? ";
    protected static String insertAndRemoveD = "update user set amount = amount + ?, cash = cash - ? where uname = ?";
    protected static String insertAndRemoveW = "update user set amount = amount - ?, cash = cash + ? where uname = ?";
    protected static String createUser = "INSERT INTO user (uname, pword, cash, amount, type) VALUES (?, ?, 0, 1000, \"user\")";
    protected static String loginUserDataCheck = "SELECT uname, pword from user where uname = ? and pword = ?";
    public DatabaseConnection(){}
        
    public static void main(String[] args) throws SQLException, FileNotFoundException, UnsupportedEncodingException{
            openConnection();
            Login.login();
            closeConnection();
    }
       
         protected static void openConnection() throws SQLException{
            conn = DriverManager.getConnection(JDBC, username, password);
         }
         
        
         protected static void closeConnection()throws SQLException{
             conn.close();
         }
}
