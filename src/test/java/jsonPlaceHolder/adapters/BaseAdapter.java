package jsonPlaceHolder.adapters;

import com.google.gson.Gson;
import framework.PropertyReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class BaseAdapter {
    PropertyReader propertyReader = new PropertyReader("config.properties");
    Gson gson = new Gson();

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
        return given().
                header("Content-type", "application/json")
                .get(propertyReader.getProperty("URL") + uri)
                .then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }
}
