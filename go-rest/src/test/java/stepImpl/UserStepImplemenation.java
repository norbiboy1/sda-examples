package stepImpl;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.payload.User;
import utils.Gender;

import static io.restassured.RestAssured.given;

public class UserStepImplemenation {
    String baseUrl ="https://gorest.co.in";
    String userEndPoint ="/public-api/users";
    private RequestSpecification requestSpecification = given().
            headers("Authorization", "Bearer 2d1bccdc24c5e8877859e0673796131efeac0ba84400ca4bb845c351369bbbeb").
            baseUri(baseUrl).
            basePath(userEndPoint).
            contentType(ContentType.JSON);

    User userPayload;


    @Given("^I want to create a new user with name (.*), gender (.*) and email address (.*)$")
    public void iWantToCreateANewUserWithNameNameGenderGenderAndEmailAddressEmail(String name, String gender, String email) {
        userPayload = new User();
        userPayload.setName(name);
        userPayload.setGender(gender);
        userPayload.setEmail(email);
        userPayload.setStatus("Active");
    }

    @When("^I create the user resource$")
    public void iCreateTheUserResource() {
       given().spec(requestSpecification).body(userPayload).post().then().log().all();
    }

    @Then("^the user will be created in the database$")
    public void theUserWillBeCreatedInTheDatabase() {

    }

    @And("^an id will be assigned to this new user$")
    public void anIdWillBeAssignedToThisNewUser() {
    }

    @And("^response status code will be (\\d+)$")
    public void responseStatusCodeWillBe(int arg0) {
    }


}
