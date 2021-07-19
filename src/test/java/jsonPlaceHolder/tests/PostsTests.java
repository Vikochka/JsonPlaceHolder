package jsonPlaceHolder.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import jsonPlaceHolder.adapters.PostsAdapter;
import jsonPlaceHolder.modals.PostsModal;
import org.testng.annotations.Test;

import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

public class PostsTests {

    @Step("Get all posts")
    @Test
    public void getAllPosts() {
        new PostsAdapter().getPost(getProperty("END_URI_POSTS"), getIntProperty("status200"));
    }

    @Step("Get only one post")
    @Test
    public void getOnlyOnePost() {
        new PostsAdapter().getPost(getProperty("END_URI_POSTS") + "99", getIntProperty("status200"));
    }

    @Step("Get error post")
    @Test
    public void getErrorPost() {
        new PostsAdapter().getPost(getProperty("END_URI_POSTS") + "150", getIntProperty("status404"));
    }

    @Step("Add new post")
    @Test
    public void createNewPost() {
        Faker faker = new Faker();

        PostsModal postsModal = PostsModal.builder()
                .userId(1)
                .id(101)
                .title(faker.dog().name())
                .body(faker.cat().name())
                .build();
        new PostsAdapter().postPost(postsModal, getProperty("END_URI_POSTS"), getIntProperty("status201"));
    }
}
