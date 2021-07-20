package jsonPlaceHolder.modals;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersModal {
    int id;
    String name;
    String username;
    String email;
    String street;
    String suite;
    String city;
    String  zipcode;
    double lat;
    double lng;
    String phone;
    String website;
    @SerializedName("name")
            String companyName;
    String catchPhrase;
    String bs;
}
