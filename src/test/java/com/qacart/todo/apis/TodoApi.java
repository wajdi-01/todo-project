package com.qacart.todo.apis;

import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TodoApi {

    private static TodoApi todoApi;
    private TodoApi() {}

    public static TodoApi getInstance() {
        if (todoApi == null) {
            todoApi = new TodoApi();
        }
        return todoApi;
    }

    public Response addTodo(User user, String item) {
        return given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .contentType(ContentType.JSON)
                .body("{item: \""+ item +"\", isCompleted: false}") //item = toto name : Learn Selenium
                .auth().oauth2(user.getAccessToken())
                .when()
                .post("/api/v1/tasks")
                .then()
                .extract().response();
    }
}
