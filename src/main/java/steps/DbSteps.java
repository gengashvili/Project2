package steps;

import data.UserData;
import io.qameta.allure.Step;
import utils.DatabaseConnection;

import java.sql.*;

public class DbSteps {
    private UserData userData = new UserData();
    private Connection connection;

    public DbSteps() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Step("insert new user into users table")
    public DbSteps insertNewUser() {
        String insertQuery = "INSERT INTO users (firstName, lastName, email, phone, dateOfBirth, password) VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

            insertStatement.setString(1, userData.firstName);
            insertStatement.setString(2, userData.lastName);
            insertStatement.setString(3, userData.email);
            insertStatement.setString(4, userData.phone);
            insertStatement.setDate(5, userData.dateOfBirth);
            insertStatement.setString(6, userData.password);

            insertStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return this;
    }


}
