package jsonPlaceHolder.tests;

import io.qameta.allure.Step;
import jsonPlaceHolder.adapters.UsersAdapter;
import org.testng.annotations.Test;

import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

public class UsersTests {

    @Step("Get all users")
    @Test
    public void getAllUsers() {
        new UsersAdapter().getUsers(getProperty("END.URI.USERS"),getIntProperty("status200"),getIntProperty("id"));
    }

    @Step("Get only one user")
    @Test
    public void getOnlyOneUser() {
        new UsersAdapter().getUser(getProperty("END.URI.USERS") ,getIntProperty("id"),getIntProperty("status200"));
    }
}
