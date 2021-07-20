package jsonPlaceHolder.adapters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import framework.BaseAdapter;
import jsonPlaceHolder.modals.UsersModal;
import lombok.extern.log4j.Log4j2;

import static com.google.gson.JsonParser.parseString;
import static framework.PropertyReader.getIntProperty;

@Log4j2
public class UsersAdapter extends BaseAdapter {
    int count;

    public int getUsers(String endUri, int status, int id, UsersModal usersModal) {
        String response = get(endUri, status);
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
        JsonObject jsonObject = (JsonObject) jsonArray.get(id-1);
        log.info("Number of users = " + jsonArray.size());
        int idOfUser = parseString(String.valueOf(jsonObject))
                .getAsJsonObject().get("id").getAsInt();
        String name = parseString(String.valueOf(jsonObject))
                .getAsJsonObject().get("name").getAsString();
        String username = parseString(String.valueOf(jsonObject))
                .getAsJsonObject().get("username").getAsString();
        String email = parseString(String.valueOf(jsonObject))
                .getAsJsonObject().get("email").getAsString();
        String street = parseString(String.valueOf(jsonObject)).getAsJsonObject()
                .getAsJsonObject("address").get("street").getAsString();
        String suite = parseString(String.valueOf(jsonObject)).getAsJsonObject()
                .getAsJsonObject("address").get("suite").getAsString();
        String city = parseString(String.valueOf(jsonObject)).getAsJsonObject()
                .getAsJsonObject("address").get("city").getAsString();
        String zipcode = parseString(String.valueOf(jsonObject)).getAsJsonObject()
                .getAsJsonObject("address").get("zipcode").getAsString();
        double lat = parseString(String.valueOf(jsonObject)).getAsJsonObject().getAsJsonObject("address")
                .getAsJsonObject("geo").get("lat").getAsDouble();
        double lng = parseString(String.valueOf(jsonObject)).getAsJsonObject().getAsJsonObject("address")
                .getAsJsonObject("geo").get("lng").getAsDouble();
        String phone = parseString(String.valueOf(jsonObject))
                .getAsJsonObject().get("phone").getAsString();
        String website = parseString(String.valueOf(jsonObject))
                .getAsJsonObject().get("website").getAsString();
        String companyName = parseString(String.valueOf(jsonObject)).getAsJsonObject()
                .getAsJsonObject("company").get("name").getAsString();
        String catchPhrase = parseString(String.valueOf(jsonObject)).getAsJsonObject()
                .getAsJsonObject("company").get("catchPhrase").getAsString();
        String bs = parseString(String.valueOf(jsonObject)).getAsJsonObject()
                .getAsJsonObject("company").get("bs").getAsString();
        if (idOfUser == usersModal.getId()) {
            log.info("Ids are equal");
        } else {
            log.info("Ids are not equal");
        }
        if (name.equals(usersModal.getName())) {
            log.info("Names are equal");
        } else {
            log.info("Names are not equal");
        }
        if (username.equals(usersModal.getUsername())) {
            log.info("User names are equal");
        } else {
            log.info("User names are not equal");
        }
        if (email.equals(usersModal.getEmail())) {
            log.info("Emails are equal");
        } else {
            log.info("Emails are not equal");
        }
        if (street.equals(usersModal.getStreet())) {
            log.info("Streets are equal");
        } else {
            log.info("Streets are not equal");
        }
        if (suite.equals(usersModal.getSuite())) {
            log.info("Suits are equal");
        } else {
            log.info("Suits are not equal");
        }
        if (city.equals(usersModal.getCity())) {
            log.info("Cities are equal");
        } else {
            log.info("Cities are not equal");
        }
        if (zipcode.equals(usersModal.getZipcode())) {
            log.info("Zipcodes are equal");
        } else {
            log.info("Zipcodes are not equal");
        }
        if (lat == usersModal.getLat()) {
            log.info("Latitude is equal");
        } else {
            log.info("Latitude is not equal");
        }
        if (lng == usersModal.getLng()) {
            log.info("Longitude is equal");
        } else {
            log.info("Longitude is not equal");
        }
        if (phone.equals(usersModal.getPhone())) {
            log.info("Phones are equal");
        } else {
            log.info("Phones are not equal");
        }
        if (website.equals(usersModal.getWebsite())) {
            log.info("Websites are equal");
        } else {
            log.info("Websites are not equal");
        }
        if (companyName.equals(usersModal.getCompanyName())) {

            log.info("Company names are equal");
        } else {
            log.info("Company names are not equal");
        }
        if (catchPhrase.equals(usersModal.getCatchPhrase())) {
            log.info("Catch phrases are equal");
        } else {
            log.info("Catch phrases are not equal");
        }
        if (bs.equals(usersModal.getBs())) {
            log.info("Bs are equal");
        } else {
            log.info("Catch phrases are not equal");
        }
        return count;
    }


    public void getUser(String endUri, int id, int status, UsersModal usersModal) {
        //  String response2 = get(endUri, status);
        //JsonArray jsonArray = (JsonArray) jsonParser.parse(response2);
        count = 10;// jsonArray.size();
        if (count > id) {
            String response = get(endUri, id, getIntProperty("status200"));
            id = parseString(response)
                    .getAsJsonObject().get("id").getAsInt();
            String name = parseString(response)
                    .getAsJsonObject().get("name").getAsString();
            String username = parseString(response)
                    .getAsJsonObject().get("username").getAsString();
            String email = parseString(response)
                    .getAsJsonObject().get("email").getAsString();
            String street = parseString(response).getAsJsonObject()
                    .getAsJsonObject("address").get("street").getAsString();
            String suite = parseString(response).getAsJsonObject()
                    .getAsJsonObject("address").get("suite").getAsString();
            String city = parseString(response).getAsJsonObject()
                    .getAsJsonObject("address").get("city").getAsString();
            String zipcode = parseString(response).getAsJsonObject()
                    .getAsJsonObject("address").get("zipcode").getAsString();
            double lat = parseString(response).getAsJsonObject().getAsJsonObject("address")
                    .getAsJsonObject("geo").get("lat").getAsDouble();
            double lng = parseString(response).getAsJsonObject().getAsJsonObject("address")
                    .getAsJsonObject("geo").get("lng").getAsDouble();
            String phone = parseString(response)
                    .getAsJsonObject().get("phone").getAsString();
            String website = parseString(response)
                    .getAsJsonObject().get("website").getAsString();
            String companyName = parseString(response).getAsJsonObject()
                    .getAsJsonObject("company").get("name").getAsString();
            String catchPhrase = parseString(response).getAsJsonObject()
                    .getAsJsonObject("company").get("catchPhrase").getAsString();
            String bs = parseString(response).getAsJsonObject()
                    .getAsJsonObject("company").get("bs").getAsString();
            if (id == usersModal.getId()) {
                log.info("Ids are equal");
            } else {
                log.info("Ids are not equal");
            }
            if (name.equals(usersModal.getName())) {
                log.info("Names are equal");
            } else {
                log.info("Names are not equal");
            }
            if (username.equals(usersModal.getUsername())) {
                log.info("User names are equal");
            } else {
                log.info("User names are not equal");
            }
            if (email.equals(usersModal.getEmail())) {
                log.info("Emails are equal");
            } else {
                log.info("Emails are not equal");
            }
            if (street.equals(usersModal.getStreet())) {
                log.info("Streets are equal");
            } else {
                log.info("Streets are not equal");
            }
            if (suite.equals(usersModal.getSuite())) {
                log.info("Suits are equal");
            } else {
                log.info("Suits are not equal");
            }
            if (city.equals(usersModal.getCity())) {
                log.info("Cities are equal");
            } else {
                log.info("Cities are not equal");
            }
            if (zipcode.equals(usersModal.getZipcode())) {
                log.info("Zipcodes are equal");
            } else {
                log.info("Zipcodes are not equal");
            }
            if (lat == usersModal.getLat()) {
                log.info("Latitude is equal");
            } else {
                log.info("Latitude is not equal");
            }
            if (lng == usersModal.getLng()) {
                log.info("Longitude is equal");
            } else {
                log.info("Longitude is not equal");
            }
            if (phone.equals(usersModal.getPhone())) {
                log.info("Phones are equal");
            } else {
                log.info("Phones are not equal");
            }
            if (website.equals(usersModal.getWebsite())) {
                log.info("Websites are equal");
            } else {
                log.info("Websites are not equal");
            }
            if (companyName.equals(usersModal.getCompanyName())) {

                log.info("Company names are equal");
            } else {
                log.info("Company names are not equal");
            }
            if (catchPhrase.equals(usersModal.getCatchPhrase())) {
                log.info("Catch phrases are equal");
            } else {
                log.info("Catch phrases are not equal");
            }
            if (bs.equals(usersModal.getBs())) {
                log.info("Bs are equal");
            } else {
                log.info("Catch phrases are not equal");
            }
        } else {
            String response = get(endUri, id, getIntProperty("status404"));
            log.info("User can not be found");
        }
    }
}