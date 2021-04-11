package ru.geekbrains.lessons.lesson9;

import java.sql.*;

public class CatBase {


    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;


    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:cats.db");
        statement = connection.createStatement();
    }

    public static void dropCreate() throws SQLException {
        statement.execute("drop table if exists cats;");
        statement.execute("create table if not exists cats (id integer primary key autoincrement, name text, color text, age integer);");
    }

    public static void insertCat(Cat c) throws SQLException {
        ps = connection.prepareStatement("insert into cats (name, color, age) values (?, ?, ?);");
        ps.setString(1, c.getName());
        ps.setString(2, c.getColor());
        ps.setInt(3,c.getAge());
        ps.executeUpdate();
    }

    public static void updateCatByID(Cat c, int id) throws SQLException {

        ps = connection.prepareStatement("update cats set name = ?, color = ?, age = ? where id = ?;");
        ps.setInt(4, id);
        ps.setString(1, c.getName());
        ps.setString(2, c.getColor());
        ps.setInt(3,c.getAge());
        ps.executeUpdate();
    }

    public static void deleteCatByID (int id) throws SQLException {

        ps = connection.prepareStatement("delete from cats where id = ?;");
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    public static void printCatByID (int id) throws SQLException{
        ps = connection.prepareStatement("select* from cats where id = ?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        System.out.printf("ID: %d | Name: %s | Color: %s | Age: %d\n", rs.getInt("id"), rs.getString("name"), rs.getString("color"),rs.getInt("age"));
    }

    public static Cat getCatByID(int id) throws SQLException{
        ps = connection.prepareStatement("select* from cats where id = ?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Cat c = new Cat (rs.getString("name"), rs.getString("color"),rs.getInt("age"));
        return c;
    }

    public static void disconnect() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
