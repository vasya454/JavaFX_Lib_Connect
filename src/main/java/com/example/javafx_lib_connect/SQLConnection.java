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
    public static ArrayList<String> getBookList(String N_chit)
    {
        ArrayList<String> res= new ArrayList<>();
        SQLConnection app = new SQLConnection();
        Connection con =app.connect();
        String s = "select \"FIO\", id_ex, title from vydacha v join \"Reader\" r on v.n_chit = r.\"N_chit\" left join \"Exemplar\" e on e.id = v.id_ex left join book b on b.isbn = e.isbn where n_chit = " + N_chit;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(s);
            while (rs.next())
            {
                String t = rs.getString("\"FIO\"");
                res.add(t);
                String t2 = rs.getString("id_ex");
                res.add(t2);
                String t3 = rs.getString("title");
                res.add(t3);
            }
            System.out.println(res);
            //con.close();
        } catch (SQLException e) {
            System.out.println("Ошибка SQL!");
        }
        return res;
    }
}
