package jsonPlaceHolder.tests;

import framework.TestListener;
import jsonPlaceHolder.adapters.UsersAdapter;
import lombok.SneakyThrows;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static framework.BaseAdapter.getBytesAnnotationWithArgs;
import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;
@Listeners(TestListener.class)
public class UsersTests {

    @SneakyThrows
    @Test
    public void getAllUsers() {
        getBytesAnnotationWithArgs("expectedResults/users.json");
        new UsersAdapter().getUsers(getProperty("END.URI.USERS"), getIntProperty("status200"), getIntProperty("id"));
    }

    @SneakyThrows
    @Test
    public void getOnlyOneUser() {
        getBytesAnnotationWithArgs("expectedResults/user.json");
        new UsersAdapter().getUser(getProperty("END.URI.USERS"), getIntProperty("id"), getIntProperty("status200"));
    }
}