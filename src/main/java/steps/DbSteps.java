package steps;

import data.UserData;
import io.qameta.allure.Step;
import utils.DatabaseConnection;
import utils.SqlQueries;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbSteps {
    private Connection connection;
    private SqlQueries sqlQueries;
    private int insertedUserId = 0;


    public DbSteps() {
        try {
            this.connection = DatabaseConnection.getConnection();
            this.sqlQueries = new SqlQueries(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Step("insert new user into users table")
    public DbSteps insertNewUser() {
        UserData userData = new UserData();

        insertedUserId = sqlQueries.insertNewUser(
                userData.getFirstName(),
                userData.getLastName(),
                userData.getPhone(),
                userData.getEmail(),
                userData.getDateOfBirth(),
                userData.getPassword()
        );

        return this;
    }

    @Step
    public UserData getInsertedUserFromDb() {
        UserData userData = new UserData();

        ResultSet resultSet = sqlQueries.getUserDataFromDb(insertedUserId);

        try {
            if (resultSet.next()) {
                userData.setFirstName(resultSet.getString("firstName"));
                userData.setLastName( resultSet.getString("lastName"));
                userData.setPhone( resultSet.getString("phone"));
                userData.setEmail(resultSet.getString("email"));
                userData.setDateOfBirth(resultSet.getDate("dateOfBirth"));
                userData.setPassword( resultSet.getString("password"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userData;
    }

}