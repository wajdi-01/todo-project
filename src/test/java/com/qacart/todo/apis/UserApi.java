package com.qacart.todo.apis;

import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static UserApi userApi;
    public static UserApi getInstance() {
        if( userApi == null) {
            userApi = new UserApi();
        }
        return userApi;
    }
    private  UserApi() {}
    public Response register(User user) {
       return given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/api/v1/users/register")
                .then()
                .extract().response();
    }

}
