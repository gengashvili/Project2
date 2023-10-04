package utils;

import java.sql.*;

public class SqlQueries {
    private  Connection connection;

    public SqlQueries(Connection connection) {
        this.connection = connection;
    }

    public int insertNewUser(String firstName, String lastName, String phone, String email, Date dateOfBirth, String password) {
        String insertQuery = "INSERT INTO users (firstName, lastName, phone, email, dateOfBirth, password) VALUES (?, ?, ?, ?, ?, ?)";
        int insertedUserId = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setDate(5, dateOfBirth);
            preparedStatement.setString(6, password);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("inserting user failed");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userId = generatedKeys.getInt(1);
                    System.out.println(userId);
                } else {
                    throw new SQLException("inserting user failed");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insertedUserId;
    }


    public ResultSet getUserDataFromDb(int insertedUserId) {
        String selectQuery = "SELECT * FROM users WHERE id = ?";
        PreparedStatement selectStatement = null;
        ResultSet resultSet = null;

        try {
            selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, insertedUserId);
            resultSet = selectStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultSet;
    }
}
