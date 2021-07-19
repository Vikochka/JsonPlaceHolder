package jsonPlaceHolder.adapters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import framework.BaseAdapter;
import jsonPlaceHolder.modals.PostsModal;
import lombok.extern.log4j.Log4j2;

import static com.google.gson.JsonParser.parseString;
import static framework.PropertyReader.getIntProperty;
import static framework.PropertyReader.getProperty;

@Log4j2
public class PostsAdapter extends BaseAdapter {

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
                }
                if (body.equals(postsModal.getBody())) {
                    log.info("Body corresponds to those passed in the request, body = " + body);
                }
            }
            log.info("Title, body, userId corresponds to those passed in the request, id is present in the response.");
        } else {
            log.info("Title, body, userId does not corresponds to those passed in the request, id is present in the response.");
        }
        return jsonObject;
    }

    public boolean getPost(String endUri, int status) {
        String response = get(endUri, status);
        try {
            JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
            log.info("Number of posts = " + jsonArray.size());

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                int id = jsonObject.get("id").getAsInt();
                if (id - i == 1) {
                    log.info(" Post's id = " + id);
                } else {
                    log.info("Post can not be found " + getIntProperty("status404"));
                }
            }
        } catch (ClassCastException e) {
        }
        return false;
    }
}
