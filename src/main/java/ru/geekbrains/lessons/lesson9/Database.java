package ru.geekbrains.lessons.lesson9;

import java.sql.*;

public class Database {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;



    public static void main(String[] args) {

        Cat c1 = new Cat ("Barsik","White", 1);
        Cat c2 = new Cat ("Murzik","Black", 2);
        Cat c3 = new Cat ("Pushok","Brown", 3);
        Cat c4 = new Cat ("Persik","Orange", 2);


        try {
            connect();
            dropCreate();

            insertCat(c1);
            insertCat(c2);
            insertCat(c3);
            insertCat(c4);

            updateCatByID(c3,2);
            deleteCatByID(3);
            printCatByID(1);

            System.out.println(getCatByID(1).toString());



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            disconnect();
        }





    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:cats.db");
        statement = connection.createStatement();
    }

    private static void dropCreate() throws SQLException {
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

    private static void updateCatByID(Cat c, int id) throws SQLException {

        ps = connection.prepareStatement("update cats set name = ?, color = ?, age = ? where id = ?;");
        ps.setInt(4, id);
        ps.setString(1, c.getName());
        ps.setString(2, c.getColor());
        ps.setInt(3,c.getAge());
        ps.executeUpdate();
    }

    private static void deleteCatByID (int id) throws SQLException {

        ps = connection.prepareStatement("delete from cats where id = ?;");
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    private static void printCatByID (int id) throws SQLException{
        ps = connection.prepareStatement("select* from cats where id = ?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        System.out.printf("ID: %d | Name: %s | Color: %s | Age: %d\n", rs.getInt("id"), rs.getString("name"), rs.getString("color"),rs.getInt("age"));
    }

    private static Cat getCatByID(int id) throws SQLException{
        ps = connection.prepareStatement("select* from cats where id = ?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Cat c = new Cat (rs.getString("name"), rs.getString("color"),rs.getInt("age"));
        return c;
    }

    private static void disconnect() {
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
