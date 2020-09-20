package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

         userDaoJDBC.createUsersTable();
         userDaoJDBC.createUsersTable();
         userDaoJDBC.createUsersTable();
         userDaoJDBC.dropUsersTable();
         userDaoJDBC.dropUsersTable();
         userDaoJDBC.createUsersTable();
         userDaoJDBC.dropUsersTable();
         userDaoJDBC.createUsersTable();
         userDaoJDBC.saveUser("Konstantin","Habensky", (byte) 34);
         userDaoJDBC.saveUser("James", "Gossling", (byte) 78);
         userDaoJDBC.saveUser("Vasiliy","Pupkin",(byte)57);
        System.out.println(userDaoJDBC.getAllUsers());
         userDaoJDBC.dropUsersTable();
         userDaoJDBC.dropUsersTable();
         userDaoJDBC.saveUser("Vlad","Vlasov", (byte) 22);
         userDaoJDBC.saveUser("Frank", "Darabont",(byte)45);
        System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.saveUser("Rich","Sarbon",(byte)36);
        userDaoJDBC.removeUserById(3);
        userDaoJDBC.removeUserById(7);
        userDaoJDBC.cleanUsersTable();


//        try {
//            ResultSet resultSet = new UserDaoJDBCImpl().util.connection.createStatement().
//                    executeQuery("SELECT * FROM Users ");
//            while (resultSet.next()) {
//
//               long id =resultSet.getLong("Id");
//               String name = resultSet.getString("FirstName");
//               String lastName =resultSet.getString("LastName");
//               byte age = resultSet.getByte("Age");
//
//
//                System.out.printf("%d. %s - %d \n", id,name,lastName,age);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }

}
