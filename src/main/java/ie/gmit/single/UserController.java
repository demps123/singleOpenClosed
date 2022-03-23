package ie.gmit.single;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController extends Validate {

    //Handles incoming JSON requests that work on User resource/entity

        //Store used by controller
        private Store store = new Store();

        //Create a new user
        public String createUser(String userJson) throws IOException {
            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(userJson, User.class);

            Validate valid = new Validate();

            if(!valid.validate(user)) {
                return "ERROR";
            }

            store.store(user);

            return "SUCCESS";
        }

 }

