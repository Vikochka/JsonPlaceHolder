package jsonPlaceHolder.tests;

import io.qameta.allure.Step;
import jsonPlaceHolder.adapters.UsersAdapter;
import jsonPlaceHolder.modals.UsersModal;
import org.testng.annotations.Test;

import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

public class UsersTests {

    @Step("Get all users")
    @Test
    public void getAllUsers() {
        UsersModal usersModal = UsersModal.builder().
                id(5).
                name("Chelsey Dietrich").
                username("Kamren").
                email("Lucio_Hettinger@annie.ca").
                street("Skiles Walks").
                suite("Suite 351").
                city("Roscoeview").
                zipcode("33263").
                lat(-31.8129).
                lng(62.5342).
                phone("(254)954-1289").
                website("demarco.info").
                companyName("Keebler LLC").
                catchPhrase("User-centric fault-tolerant solution").
                bs("revolutionize end-to-end systems").
                build();
        new UsersAdapter().getUsers(getProperty("END.URI.USERS"),getIntProperty("status200"),5,usersModal);
    }

    @Step("Get only one user")
    @Test
    public void getOnlyOneUser() {
        UsersModal usersModal = UsersModal.builder().
                id(5).
                name("Chelsey Dietrich").
                username("Kamren").
                email("Lucio_Hettinger@annie.ca").
                street("Skiles Walks").
                suite("Suite 351").
                city("Roscoeview").
                zipcode("33263").
                lat(-31.8129).
                lng(62.5342).
                phone("(254)954-1289").
                website("demarco.info").
                companyName("Keebler LLC").
                catchPhrase("User-centric fault-tolerant solution").
                bs("revolutionize end-to-end systems").
                build();
        new UsersAdapter().getUser(getProperty("END.URI.USERS") ,5,getIntProperty("status200"),usersModal);
    }
}
