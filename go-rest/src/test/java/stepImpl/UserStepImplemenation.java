package stepImpl;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import model.payload.User;
import model.response.UserResponse;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.GenerateRandom.generateRandomEmail;

public class UserStepImplemenation {
    String baseUrl ="https://gorest.co.in";
    String userEndPoint ="/public-api/users";
    private RequestSpecification requestSpecification = given().
            headers("Authorization", "Bearer 2d1bccdc24c5e8877859e0673796131efeac0ba84400ca4bb845c351369bbbeb").
            baseUri(baseUrl).
            basePath(userEndPoint).
            contentType(ContentType.JSON);

    User userPayload;
    Response postResponse;
    UserResponse userResponse;

    @Given("^I want to create a new user with name (.*), gender (.*) and email address (.*)$")
    public void iWantToCreateANewUserWithNameNameGenderGenderAndEmailAddressEmail(String name, String gender, String email) {
        userPayload = new User();
        userPayload.setName(name);
        userPayload.setGender(gender);

        userPayload.setEmail(generateRandomEmail(email));
        userPayload.setStatus("Active");
    }

    @When("^I create the user resource$")
    public void iCreateTheUserResource() {
         postResponse = given().spec(requestSpecification).body(userPayload).post().then().log().all().extract().response();
         userResponse = postResponse.getBody().as(UserResponse.class);


    }

    @Then("^the user will be created in the database with the name (.*)$")
    public void theUserWillBeCreatedInTheDatabase(String expectedName) {
        String actualName = userResponse.getUserCreationResponse().getName();
        assertEquals(actualName, expectedName);
    }

    @And("^an id will be assigned to this new user$")
    public void anIdWillBeAssignedToThisNewUser() {
        boolean flag;
        int createUserId = userResponse.getUserCreationResponse().getId();
        if(createUserId != 0){
            flag = true;
        } else
            flag = false;
        assertTrue(flag);
    }

    @And("^response status code will be (.*)$")
    public void responseStatusCodeWillBe(int expectedStatusCode) {
        int actualStatusCode = postResponse.getStatusCode();
        assertEquals(actualStatusCode, expectedStatusCode);
    }


}
