package jsonPlaceHolder.adapters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import framework.BaseAdapter;
import framework.PropertyReader;
import jsonPlaceHolder.modals.PostsModal;
import lombok.extern.log4j.Log4j2;

import static com.google.gson.JsonParser.parseString;
import static framework.PropertyReader.getIntProperty;

@Log4j2
public class PostsAdapter extends BaseAdapter {
    private int count;
    int id;
    PropertyReader propertyReader = new PropertyReader("posts.properties");

    public JsonObject postPost(PostsModal postsModal, String uri, int status) {
        String response = post(gson.toJson(postsModal), uri, status);

        JsonObject jsonObject = parseString(response)
                .getAsJsonObject();

        int userId = parseString(response)
                .getAsJsonObject().get("userId").getAsInt();

        int id = parseString(response)
                .getAsJsonObject().get("id").getAsInt();

        String title = parseString(response)
                .getAsJsonObject().get("title").getAsString();

        String body = parseString(response)
                .getAsJsonObject().get("body").getAsString();

        if (userId == postsModal.getUserId()) {
            log.info("UserId corresponds to those passed in the request, userId = " + userId);
            if (id == postsModal.getId()) {
                log.info("id is present in the response, Id = " + id);
                if (title.equals(postsModal.getTitle())) {
                    log.info("Title corresponds to those passed in the request, title = " + title);
                    if (body.equals(postsModal.getBody())) {
                        log.info("Body corresponds to those passed in the request, body = " + body);
                    }
                }
            }
            log.info("Title, body, userId corresponds to those passed in the request, id is present in the response.");
        } else {
            log.info("Title, body, userId does not corresponds to those passed in the request, id is present in the response.");
        }
        return jsonObject;
    }

    public int getPosts(String endUri, int status) {
        String response = get(endUri, status);
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
        log.info("Number of posts = " + jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            id = jsonObject.get("id").getAsInt();
            if (id - i == 1) {
                return id;
            } else {
                log.info("Post can not be found " + getIntProperty("status404"));
            }
        }
        return count = jsonArray.size();
    }

    public void getPost(String endUri, int id) {
        //String response2 = get(endUri, 200);
        //JsonArray jsonArray = (JsonArray) jsonParser.parse(response2);
        count = 100;// jsonArray.size();
        if (count >= id) {
            String response = get(endUri, id, getIntProperty("status200"));
            int userId = parseString(response)
                    .getAsJsonObject().get("userId").getAsInt();
            int idOfPost = parseString(response)
                    .getAsJsonObject().get("id").getAsInt();
            String title = parseString(response)
                    .getAsJsonObject().get("title").getAsString();
            String body = parseString(response)
                    .getAsJsonObject().get("body").getAsString();
            if (userId == propertyReader.getIntProperty("userId")) {
                log.info("UserId corresponds to those passed in the request, userId = " + userId);
                if (idOfPost == propertyReader.getIntProperty("id")) {
                    log.info("Id is present in the response, Id = " + id);
                    if (!title.isEmpty()) {
                        log.info("Title corresponds to those passed in the request, title = " + title);
                        if (!body.isEmpty()) {
                            log.info("Body corresponds to those passed in the request, body = " + body);
                        } else {
                            log.error("Body is empty");
                        }
                    } else {
                        log.error("Title is empty");
                    }
                } else {
                    log.error("Id is not present in the response");
                }
                log.info("Title, body, userId corresponds to those passed in the request, id is present in the response.");
            } else {
                log.error("UserId does not corresponds to those passed in the request, id is present in the response.");
            }
        } else if (count < id) {
            String response = get(endUri, id, getIntProperty("status404"));
            if (response.equals(propertyReader.getProperty("error.post"))) {
                log.info("Post is empty");
            } else {
                log.error("Post is not empty");
            }
            log.info("Post can not be found");
        }
    }
}