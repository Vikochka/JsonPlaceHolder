package jsonPlaceHolder.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import jsonPlaceHolder.adapters.PostsAdapter;
import jsonPlaceHolder.modals.PostsModal;
import org.testng.annotations.Test;

import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

public class PostsTests {

    @Step
    @Test
    public void getAllPosts() {
        new PostsAdapter().getPosts(getProperty("END_URI_POSTS"), getIntProperty("status200"));
    }

    @Step
    @Test
    public void getOnlyOnePost() {
        new PostsAdapter().getPost(getProperty("END_URI_POSTS"), getIntProperty("id"));
    }

    @Step
    @Test
    @Description("Get {error.id} post")
    public void getErrorPost() {
        new PostsAdapter().getPost(getProperty("END_URI_POSTS"), getIntProperty("error.id"));
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
