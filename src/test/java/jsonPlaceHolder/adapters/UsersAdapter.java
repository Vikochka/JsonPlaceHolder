package jsonPlaceHolder.adapters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import framework.BaseAdapter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UsersAdapter extends BaseAdapter {

    public boolean getUser(String endUri, int status) {
        String response = get(endUri, status);
        try {
            JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
            log.info("Number of users = " + jsonArray.size());
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                int idOfUser = jsonObject.get("id").getAsInt();
                if (idOfUser - i == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ClassCastException e) {
        }
        return false;
    }
}