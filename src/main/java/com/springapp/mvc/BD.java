package com.springapp.mvc;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Created by Marat on 22.06.2016.
 */
public class BD {
    private static final String URL = "jdbc:mysql://localhost:3306/cloude";
    private static final String USER = "root";
    private static final String PASS = "rhtjynbjc1";

    private static Connection conn = null;
    private static Statement stm = null;
    private static PreparedStatement PS = null;

    public BD() {}

    public static Connection getCon() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        if(conn == null){
            conn = DriverManager.getConnection(URL, USER, PASS);
        }
        return conn;
    }

    public static Statement getStm() throws Exception{
        if(stm == null){
            stm = getCon().createStatement();
        }
        return stm;
    }
    public static PreparedStatement getPS(String SQL) throws Exception{
        if(PS == null){
            PS = getCon().prepareStatement(SQL);
        }
        return PS;
    }
}
