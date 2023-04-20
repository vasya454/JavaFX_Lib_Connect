package com.example.javafx_lib_connect;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnection {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "1";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static ArrayList<String> getBookList()
    {
        ArrayList<String> res= new ArrayList<>();
        SQLConnection app = new SQLConnection();
        Connection con =app.connect();
        String s = "select fio from author";
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(s);
            while (rs.next())
            {
                String t = rs.getString("fio");
                res.add(t);
            }
            //con.close();
        } catch (SQLException e) {
            System.out.println("упс");
        }
        return res;
    }
}
