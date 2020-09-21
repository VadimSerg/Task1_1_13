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
    }
}
