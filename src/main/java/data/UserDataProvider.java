package data;

import org.testng.annotations.DataProvider;
import steps.DbSteps;
import utils.Helper;

public class UserDataProvider {
    DbSteps dbSteps = new DbSteps();

    @DataProvider(name = "userDataProvider")
    public Object[][] provideUserData() {
        UserData userData = dbSteps.getUserDataFromDb();

        Object[][] data = new Object[][] {
                {
                        userData.firstName,
                        userData.lastName,
                        userData.email,
                        userData.phone,
                        Helper.formatSqlDate(userData.dateOfBirth, "MM-dd-yyyy"),
                        userData.password
                }
        };

        return data;
    }
}
