package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private Util util =  new Util();
    private Connection connection= util.getSession();


    public UserDaoJDBCImpl() {
    }



    public void createUsersTable()  {

        try  {
            connection.createStatement().executeUpdate("CREATE TABLE   IF NOT EXISTS users " +
                    "(Id BIGINT PRIMARY KEY AUTO_INCREMENT,  FirstName TINYTEXT , " +
                    "LastName TINYTEXT ,  Age TINYINT)");

            System.out.println("Table was created successfully");
           // connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try {
            connection.createStatement().executeUpdate("DROP TABLE IF EXISTS Users ");
            System.out.println("Table was removed successfully");
         //   connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        try {
           // System.out.println(databaseMetaData().getTables(null,null,"users",null));
            new UserDaoJDBCImpl().createUsersTable();
            PreparedStatement preparedStatement =connection.
            prepareStatement("INSERT  Users (FirstName,LastName,Age) VALUE(?,?,?) ");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setLong(3,user.getAge());
            preparedStatement.executeUpdate();
            //connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM Users  WHERE Id=?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            //connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
           ResultSet resultSet =  connection.
                   createStatement().executeQuery("SELECT *FROM  users");
           while (resultSet.next()) {
             list.add(new User(resultSet.getString("FirstName"),
                     resultSet.getString("LastName"),
                     resultSet.getByte("Age")));
           }
           //connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try {
            connection.createStatement().executeUpdate("DELETE FROM Users");
           // connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}



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
