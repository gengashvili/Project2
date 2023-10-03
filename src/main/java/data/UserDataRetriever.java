package data;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataRetriever {
    private Connection connection = DatabaseConnection.getConnection();

    public UserDataRetriever() throws SQLException {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // თავიდან ეს მეთოდიც DbSteps კლასში მეწერა, მაგრამ მერე ცალკე კლასში გადმოვიტანე, რადგან უშუალოდ ტესტში არ ვიძახებ და როგორც ასეთი step-ს არ წარმოადგნეს
    public ResultSet getUserDataFromDb() {
        String selectQuery = "SELECT TOP 1 * FROM users ORDER BY id DESC";
        PreparedStatement selectStatement = null;
        ResultSet resultSet = null;

        try {
            selectStatement = connection.prepareStatement(selectQuery);
            resultSet = selectStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }
}
