package jsonPlaceHolder.adapters;

public class UsersAdapter extends BaseAdapter {

    public void getUser(String enduri, int status) {
        String response = get(enduri, status);
        String jsonObject = gson.toJson(response);
        String[] users;
        users = jsonObject.split(",");
        for (int i = 0; i < users.length; i++) {

        }
    }

}
