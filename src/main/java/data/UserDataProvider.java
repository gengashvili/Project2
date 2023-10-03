package data;

import org.testng.annotations.DataProvider;
import steps.DbSteps;
import utils.Helper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataProvider {
    DbSteps dbSteps = new DbSteps();
    UserDataRetriever userDataRetriever;

    public UserDataProvider() throws SQLException {
        this.userDataRetriever = new UserDataRetriever();
    }


    @DataProvider(name = "userDataProvider")
    public Object[][] provideUserData() {
        ResultSet resultSet = userDataRetriever.getUserDataFromDb();

        Object[][] data = null;

        try {
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String password = resultSet.getString("password");

                data = new Object[][] {
                        {
                                firstName,
                                lastName,
                                email,
                                phone,
                                Helper.formatSqlDate(dateOfBirth, "MM-dd-yyyy"),
                                password
                        }
                };
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return data;
    }

}
