package jsonPlaceHolder.adapters;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jsonPlaceHolder.modals.PostsModal;

public class PostsAdapter extends BaseAdapter {
    JsonParser jsonParser = new JsonParser();

    public JsonObject postPost(PostsModal postsModal, String uri, int status) {
        String response = post(gson.toJson(postsModal), uri, status);

        JsonObject jsonObject = jsonParser.parseString(response)
                .getAsJsonObject();

        int userId = jsonParser.parseString(response)
                .getAsJsonObject().get("userId").getAsInt();
        int id = jsonParser.parseString(response)
                .getAsJsonObject().get("id").getAsInt();

        String title = jsonParser.parseString(response)
                .getAsJsonObject().get("title").getAsString();

        String body = jsonParser.parseString(response)
                .getAsJsonObject().get("body").getAsString();

        if (userId == postsModal.getUserId()) {
            System.out.println("UserId corresponds to those passed in the request, userId = " + userId);
            if (id == postsModal.getId()) {
                System.out.println("id is present in the response, Id = " + id);
                if (title.equals(postsModal.getTitle())) {
                    System.out.println("Title corresponds to those passed in the request, title = " + title);
                }
                if (body.equals(postsModal.getBody())) {
                    System.out.println("Body corresponds to those passed in the request, body = " + body);
                }
            }
            System.out.println("Title, body, userId corresponds to those passed in the request, id is present in the response.");
        } else {
            System.out.println("Title, body, userId does not corresponds to those passed in the request, id is present in the response.");
        }
        return jsonObject;
    }

    public void getPost(String endUri, int status) {
        String response = get(endUri, status);
    }
}
