package framework;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import io.qameta.allure.Attachment;
import io.restassured.http.ContentType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    PropertyReader propertyReader = new PropertyReader("config.properties");
    protected Gson gson = new Gson();
    protected JsonParser jsonParser = new JsonParser();

    public String post(String body, String uri, int status) {
        return given().
                header("Content-type", "application/json").
                body(body).
                when().
                post(PropertyReader.getProperty("URL") + uri).
                then().
                log().all().
                statusCode(status).
                and().
                contentType(ContentType.JSON).
                extract().body().asString();
    }

    public String get(String uri, int status) {
        String string = given().
                header("Content-type", "application/json")
                .get(propertyReader.getProperty("URL") + uri)
                .then().
                        log().all().
                        statusCode(status).
                        and().
                        contentType(ContentType.JSON).
                        extract().body().asString();
        return string;
    }

    public String get(String uri, int id, int status) {
        String string = given().
                header("Content-type", "application/json")
                .get(propertyReader.getProperty("URL") + uri + id)
                .then().
                        log().all().
                        statusCode(status).
                        and().
                        contentType(ContentType.JSON).
                        extract().body().asString();
        return string;
    }

    @Attachment(value = "Expected result", type = "application/json", fileExtension = ".txt")
    public static byte[] getBytesAnnotationWithArgs(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/test/resources", resourceName));
    }
}