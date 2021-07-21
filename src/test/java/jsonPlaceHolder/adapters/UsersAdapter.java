package jsonPlaceHolder.adapters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import framework.BaseAdapter;
import framework.PropertyReader;
import lombok.extern.log4j.Log4j2;

import static com.google.gson.JsonParser.parseString;
import static framework.PropertyReader.getIntProperty;

@Log4j2
public class UsersAdapter extends BaseAdapter {
    PropertyReader property = new PropertyReader("users.properties");
    int count;

    public int getUsers(String endUri, int status, int id) {
        String response = get(endUri, status);
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response);
        JsonObject jsonObject = (JsonObject) jsonArray.get(id - 1);
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
        String lat = parseString(String.valueOf(jsonObject)).getAsJsonObject().getAsJsonObject("address")
                .getAsJsonObject("geo").get("lat").getAsString();
        String lng = parseString(String.valueOf(jsonObject)).getAsJsonObject().getAsJsonObject("address")
                .getAsJsonObject("geo").get("lng").getAsString();
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
        if (idOfUser == property.getIntProperty("id")) {
            log.info("Ids are equal");
        } else {
            log.error("Ids are not equal");
        }
        if (name.equals(property.getProperty("name"))) {
            log.info("Names are equal");
        } else {
            log.error("Names are not equal");
        }
        if (username.equals(property.getProperty("username"))) {
            log.info("User names are equal");
        } else {
            log.error("User names are not equal");
        }
        if (email.equals(property.getProperty("email"))) {
            log.info("Emails are equal");
        } else {
            log.error("Emails are not equal");
        }
        if (street.equals(property.getProperty("street"))) {
            log.info("Streets are equal");
        } else {
            log.error("Streets are not equal");
        }
        if (suite.equals(property.getProperty("suite"))) {
            log.info("Suits are equal");
        } else {
            log.error("Suits are not equal");
        }
        if (city.equals(property.getProperty("city"))) {
            log.info("Cities are equal");
        } else {
            log.error("Cities are not equal");
        }
        if (zipcode.equals(property.getProperty("zipcode"))) {
            log.info("Zipcodes are equal");
        } else {
            log.error("Zipcodes are not equal");
        }
        if (lat.equals(property.getProperty("lat"))) {
            log.info("Latitude is equal");
        } else {
            log.error("Latitude is not equal");
        }
        if (lng.equals(property.getProperty("lng"))) {
            log.info("Longitude is equal");
        } else {
            log.error("Longitude is not equal");
        }
        if (phone.equals(property.getProperty("phone"))) {
            log.info("Phones are equal");
        } else {
            log.error("Phones are not equal");
        }
        if (website.equals(property.getProperty("website"))) {
            log.info("Websites are equal");
        } else {
            log.error("Websites are not equal");
        }
        if (companyName.equals(property.getProperty("companyName"))) {

            log.info("Company names are equal");
        } else {
            log.error("Company names are not equal");
        }
        if (catchPhrase.equals(property.getProperty("catchPhrase"))) {
            log.info("Catch phrases are equal");
        } else {
            log.error("Catch phrases are not equal");
        }
        if (bs.equals(property.getProperty("bs"))) {
            log.info("Bs are equal");
        } else {
            log.error("Catch phrases are not equal");
        }
        return count;
    }

    public void getUser(String endUri, int id, int status) {
        String response2 = get(endUri, status);
        JsonArray jsonArray = (JsonArray) jsonParser.parse(response2);
        count = jsonArray.size();
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
            String lat = parseString(response).getAsJsonObject().getAsJsonObject("address")
                    .getAsJsonObject("geo").get("lat").getAsString();
            String lng = parseString(response).getAsJsonObject().getAsJsonObject("address")
                    .getAsJsonObject("geo").get("lng").getAsString();
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
            if (id == property.getIntProperty("id")) {
                log.info("Ids are equal");
            } else {
                log.error("Ids are not equal");
            }
            if (name.equals(property.getProperty("name"))) {
                log.info("Names are equal");
            } else {
                log.error("Names are not equal");
            }
            if (username.equals(property.getProperty("username"))) {
                log.info("User names are equal");
            } else {
                log.error("User names are not equal");
            }
            if (email.equals(property.getProperty("email"))) {
                log.info("Emails are equal");
            } else {
                log.error("Emails are not equal");
            }
            if (street.equals(property.getProperty("street"))) {
                log.info("Streets are equal");
            } else {
                log.error("Streets are not equal");
            }
            if (suite.equals(property.getProperty("suite"))) {
                log.info("Suits are equal");
            } else {
                log.error("Suits are not equal");
            }
            if (city.equals(property.getProperty("city"))) {
                log.info("Cities are equal");
            } else {
                log.error("Cities are not equal");
            }
            if (zipcode.equals(property.getProperty("zipcode"))) {
                log.info("Zipcodes are equal");
            } else {
                log.error("Zipcodes are not equal");
            }
            if (lat.equals(property.getProperty("lat"))) {
                log.info("Latitude is equal");
            } else {
                log.error("Latitude is not equal");
            }
            if (lng.equals(property.getProperty("lng"))) {
                log.info("Longitude is equal");
            } else {
                log.error("Longitude is not equal");
            }
            if (phone.equals(property.getProperty("phone"))) {
                log.info("Phones are equal");
            } else {
                log.error("Phones are not equal");
            }
            if (website.equals(property.getProperty("website"))) {
                log.info("Websites are equal");
            } else {
                log.error("Websites are not equal");
            }
            if (companyName.equals(property.getProperty("companyName"))) {

                log.info("Company names are equal");
            } else {
                log.error("Company names are not equal");
            }
            if (catchPhrase.equals(property.getProperty("catchPhrase"))) {
                log.info("Catch phrases are equal");
            } else {
                log.error("Catch phrases are not equal");
            }
            if (bs.equals(property.getProperty("bs"))) {
                log.info("Bs are equal");
            } else {
                log.error("Catch phrases are not equal");

            }
        } else {
            String response = get(endUri, id, getIntProperty("status404"));
            log.info("User can not be found");
        }
    }
}