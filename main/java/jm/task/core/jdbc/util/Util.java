package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private String url ="jdbc:mysql://localhost/vadim_5?serverTimezone=Asia/Vladivostok&useSSL=false";
    private  String password ="IwannaBeAdeveloper2312&";
    private  String username ="Vadim";
    private  Connection session;

    public Connection getSession() {
        try {
            session = DriverManager.getConnection(url, username, password);
        }   catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return session;
    }
}

