package stepImpl;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.payload.Post;
import model.response.PostResponse;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostStepImplementation {


    String baseUrl = "https://gorest.co.in";
    String userEndPoint = "/public-api/users/";
    String postPath = "/posts";
    String previousCreatedUser = "1635";

    private RequestSpecification requestSpecification = given().
            headers("Authorization", "Bearer e9e53ceda5fbd35a7c441bd9549fa260c4ba650e51352247ebc1cd632c525dd1").
            baseUri(baseUrl).
            basePath(userEndPoint + previousCreatedUser + postPath).
            contentType(ContentType.JSON);
    Post postPayload;
    PostResponse postResponseBody;

    @Given("^the previous created user wants to publish a new post with title (.*)")
    public void thePreviousCreatedUserWantsToPublishANewPostWithTitleTitle(String title) {
        postPayload = new Post();
        postPayload.setPostTitle(title);


    }

    @And("^the post will contain the message (.*)$")
    public void thePostWillContainTheMessageMessage(String message) {
        postPayload.setPostMessage(message);
    }

    @When("he will publish the post")
    public void heWillPublishThePost() {
        Response postCreationResponse = given().spec(requestSpecification).body(postPayload).post().then().log().all().extract().response();
        postResponseBody = postCreationResponse.getBody().as(PostResponse.class);
    }

    @Then("the post will be available for my followers")
    public void thePostWillBeAvailableForMyFollowers() {

        assertNotNull(postResponseBody.getPostCreationResponse().getPostMessage());

    }
}
