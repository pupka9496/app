package ru.jdrm.jdrmapp.DB;

import android.os.AsyncTask;

import java.sql.*;
import java.util.concurrent.CompletableFuture;


public class DBHelper {
    private static final String IP = "95.163.231.54";
    private static final String PORT = "1433";
    private static final String CLASS_NAME = "net.sourceforge.jtds.jdbc.Driver";
    private static final String DATABASE = "master";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "StrongP@ssword";
    public static final String URL = "jdbc:jtds:sqlserver://" + IP + ";port=" + PORT + ";databaseName=" + DATABASE;
    public static Connection connection = null;

    private DBHelper() {}

    public static void connectAsync() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Class.forName(CLASS_NAME);
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).thenAccept(conn -> {
            connection = conn;
        });
    }

    public static void closeConn(Connection con, Statement ps, ResultSet set) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}