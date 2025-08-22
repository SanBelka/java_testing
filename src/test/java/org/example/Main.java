import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Main {

    @Test
    public void getPostsTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200) // проверка статуса ответа
                .extract().response();

        System.out.println("Response: " + response.asString());

        Assert.assertTrue(response.asString().contains("userId"));
    }

    @Test
    public void createPostTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "foo");
        requestParams.put("body", "bar");
        requestParams.put("userId", 1);

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestParams.toString())
                .when()
                .post("/posts")
                .then()
                .statusCode(201) // Created
                .extract().response();

        System.out.println("Created Post: " + response.asString());
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
    }
}
