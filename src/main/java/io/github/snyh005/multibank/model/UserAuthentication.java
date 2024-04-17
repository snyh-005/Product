package io.github.snyh005.multibank.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserAuthentication {

    public static final String username = "snyh005";

    public static final String password = "password1234";

    public static final String token = "fsdfsdfgsdgsdgsdgs"; //Ideally it should be generated using user details and ttl


    public String name;

    public String credential;


    public String getToken(String username , String password) throws Exception {
        if(UserAuthentication.username.equalsIgnoreCase(username)  && UserAuthentication.password.equalsIgnoreCase(password)) {
            return UserAuthentication.token;
        }
        throw new Exception("Unauthorized login");
    }

    public void isAuthenticated(String token) throws Exception {
         if(!token.equalsIgnoreCase("bearer "+ UserAuthentication.token)) {
         throw new Exception();
         }
    }



}
