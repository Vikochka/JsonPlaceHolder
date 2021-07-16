package jsonPlaceHolder.modals;

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
    int zipcode;
    double lat;
    double lng;
    String phone;
    String website;
    String catchPhrase;
    String bs;
}
