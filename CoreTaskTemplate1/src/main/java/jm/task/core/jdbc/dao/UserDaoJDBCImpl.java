package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

//    private String url;
//    private  String username;
//    private String password;

    User user;


    private  String sqlCreateTable ="CREATE TABLE   IF NOT EXISTS users (Id BIGINT PRIMARY KEY AUTO_INCREMENT,  FirstName TINYTEXT , " +
        "LastName TINYTEXT ,  Age TINYINT)";
    private  String sqlDropTables = "DROP TABLE IF EXISTS Users ";

    public Util util =  new Util();

//    DatabaseMetaData databaseMetaData() {
//         DatabaseMetaData dmb = null;
//
//        try {
//             dmb =util.connect().getMetaData();
//             return dmb;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return dmb;
//    }

//    ResultSet resultSetGet(){
//        ResultSet resultSet =null;
//        try {
//            resultSet = databaseMetaData().getTables(null,null,"users",null);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return resultSet;
//    }


    public UserDaoJDBCImpl() {
    }



    public void createUsersTable()  {

        try {
            util.connect().createStatement().executeUpdate(sqlCreateTable);
            util.connect().close();
            System.out.println("Table was created successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try {
            util.connect().createStatement().executeUpdate(sqlDropTables);
            System.out.println("Table was removed successfully");
            util.connect().close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        try {
           // System.out.println(databaseMetaData().getTables(null,null,"users",null));
            new UserDaoJDBCImpl().createUsersTable();
            PreparedStatement preparedStatement =util.connect().
            prepareStatement("INSERT  Users (FirstName,LastName,Age) VALUE(?,?,?) ");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setLong(3,user.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement =util.connect().prepareStatement("DELETE FROM Users  WHERE Id=?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

//            util.connection.createStatement().executeUpdate("DELETE FROM Users WHERE Id=id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
           ResultSet resultSet =  util.connect().
                   createStatement().executeQuery("SELECT *FROM  users");
           while (resultSet.next()) {
             list.add(new User(resultSet.getString("FirstName"),
                     resultSet.getString("LastName"),
                     resultSet.getByte("Age")));
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try {
            util.connect().createStatement().executeUpdate("DELETE FROM Users");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
