package framework;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

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
                statusCode(status)
                .extract().body().asString();
    }

    public String get(String uri, int status) {
        String string = given().
                header("Content-type", "application/json")
                .get(propertyReader.getProperty("URL") + uri)
                .then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
        return string;
    }

    public String get(String uri,int id, int status) {
        String string = given().
                header("Content-type", "application/json")
                .get(propertyReader.getProperty("URL") + uri + id)
                .then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
        return string;
    }
}