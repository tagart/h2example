package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        PreparedStatement statement = connection.prepareStatement("WITH TABLE1 AS (SELECT 1 A FROM DUAL WHERE ? = 1) SELECT A FROM (SELECT A FROM TABLE1)");
        statement.setInt(1, 1);
        ResultSet resultSet = statement.executeQuery();
        System.out.println("Has rows: " + resultSet.next());
        connection.close();
    }
}
