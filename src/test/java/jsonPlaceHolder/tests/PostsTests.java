package jsonPlaceHolder.tests;

import com.github.javafaker.Faker;
import framework.TestListener;
import jsonPlaceHolder.adapters.PostsAdapter;
import jsonPlaceHolder.modals.PostsModal;
import lombok.SneakyThrows;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static framework.BaseAdapter.getBytes;
import static framework.BaseAdapter.getBytesAnnotationWithArgs;
import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

@Listeners(TestListener.class)
public class PostsTests {

    @SneakyThrows
    @Test
    public void getAllPosts() {
        getBytesAnnotationWithArgs("expectedResults/posts.json");
        new PostsAdapter().getPosts(getProperty("END_URI_POSTS"), getIntProperty("status200"));
    }

    @SneakyThrows
    @Test
    public void getOnlyOnePost() {
        getBytesAnnotationWithArgs("expectedResults/post.json");
        new PostsAdapter().getPost(getProperty("END_URI_POSTS"), getIntProperty("id"), getIntProperty("status200"));
    }

    @SneakyThrows
    @Test
    public void getErrorPost() {
        getBytesAnnotationWithArgs("expectedResults/error_post.json");
        new PostsAdapter().getPost(getProperty("END_URI_POSTS"), getIntProperty("error.id"), getIntProperty("status404"));
    }

    @SneakyThrows
    @Test
    public void createNewPost() {
        getBytes("expectedResults/img.png");
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