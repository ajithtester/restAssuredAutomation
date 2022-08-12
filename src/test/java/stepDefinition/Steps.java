package stepDefinition;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;

import excelRead.ReadTestData;
import hooks.ApiRequirements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import swaggerUi_modules.ApiRequestBody;

public class Steps extends ReadTestData {


	public static Response  AccountResponse;
	public static String  userID;
	public static String tokenNumber;
	public static String postID;


	//<--------------------------Post method------------------------------>

	@Given("User creating a new account in IEB app")
	public void user_creating_a_new_account_in_IEB_app() throws Throwable {

		try {
			AccountResponse =	ApiRequirements.Request.body(ApiRequestBody.newAccountInputs()).
					post(ApiRequirements.postNewAccount);
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Then("Account should be created")
	public void account_should_be_created() throws Throwable{
		try {
			AccountResponse.prettyPrint();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@And("Validating the created account")
	public void validating_the_created_account() throws Throwable {
		try {
			String response = 	AccountResponse.getBody().asString();
			String givenEmail = ApiRequirements.jsonStringParser(response, "result.email");
			String givenphone =  ApiRequirements.jsonStringParser(response, "result.phone"); ;


			int statusCode= AccountResponse.statusCode();
			Assert.assertEquals(statusCode, 200);

			Assert.assertEquals(givenEmail, readTestData(5, 5, AccountCreation));
			Assert.assertEquals(givenphone, readTestData(3, 5, AccountCreation));
			Assert.assertEquals(statusCode, 200);
			System.err.println("Account created and validated successfully");
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	//<--------------------------Post method------------------------------>

	@Given("User login a verified account")
	public void user_login_a_verified_account() throws Throwable {

		try {

			AccountResponse =	ApiRequirements.Request.given().body(ApiRequestBody.loginInputs()).
					post(ApiRequirements.postLogin);

			AccountResponse.prettyPrint();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Then("Account should be logged in successfully")
	public void account_should_be_logged_in_successfully() throws Throwable {

		try {

			String response =	AccountResponse.getBody().asString();
			String phoneNumber = ApiRequirements.jsonStringParser(response, "result.phone");
			tokenNumber = ApiRequirements.jsonStringParser(response, "result.token");

			int ID = ApiRequirements.jsonIntParser(response, "result.id");
			userID = Integer.toString(ID);
			Assert.assertEquals(phoneNumber, readTestData(1, 6, "Login"));
			System.err.println("User logged in and validated successfully");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	//<--------------------------Get method------------------------------>

	@Given("User submits the userID in the api")
	public void user_submits_the_userID_in_the_api() throws Throwable {

		try {
			Map<String, Object> h = new LinkedHashMap<String, Object>();
			h.put(ApiRequirements.Authorise, tokenNumber);
			ApiRequirements.Request.headers(h);
			AccountResponse =	ApiRequirements.Request.get("user/"+userID);
			AccountResponse.prettyPrint();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}


	}

	@Then("Account should be viewed")
	public void account_should_be_viewed()  throws Throwable{

		try {

			String response = AccountResponse.getBody().asString();
			String phone  = ApiRequirements.jsonStringParser(response, "result.phone");
			Assert.assertEquals("8848546901" , phone);

			int statusCode= AccountResponse.statusCode();
			Assert.assertEquals(statusCode, 200);
			System.err.println("Account info viewed and validated successfully");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	//<--------------------------Patch method------------------------------>

	@Given("User changes the password")
	public void user_changes_the_password() throws Throwable {

		try {
			Map<String, Object> h = new LinkedHashMap<String, Object>();
			h.put(ApiRequirements.Authorise, tokenNumber);
			ApiRequirements.Request.headers(h);
			AccountResponse = ApiRequirements.Request.body(ApiRequestBody.changePassword()).patch(ApiRequirements.changePassword);
			AccountResponse.prettyPrint();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Then("Password should be updated")
	public void password_should_be_updated() throws Throwable {

		try {

			String response = AccountResponse.getBody().asString();
			String message = ApiRequirements.jsonStringParser(response, "result.message");
			Assert.assertEquals(message, "Password Changed Successfully");
			
			System.err.println("Password changed and validated successfully");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	//<--------------------------Post method------------------------------>

	@Given("User creates a new post")
	public void user_creates_a_new_post() throws Throwable {

		try {
			Map<String, Object> h = new LinkedHashMap<String, Object>();
			h.put(ApiRequirements.Authorise, tokenNumber);
			ApiRequirements.Request.headers(h);
			AccountResponse = ApiRequirements.Request.body(ApiRequestBody.createPost()).post("/post");
			AccountResponse.prettyPrint();


		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Then("Post should be created")
	public void post_should_be_created() throws Throwable {

		try {
			String response =	AccountResponse.getBody().asString();
			int ID =	ApiRequirements.jsonIntParser(response, "result.task_attachments[0].post_id");
			postID  = Integer.toString(ID);
			
			System.err.println("Post created successfully");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	//<--------------------------Delete method------------------------------>

	@Given("User deletes a post")
	public void user_deletes_a_post() throws Throwable {

		try {
			Map<String, Object> h = new LinkedHashMap<String, Object>();
			h.put(ApiRequirements.Authorise, tokenNumber);
			ApiRequirements.Request.headers(h);
			AccountResponse = ApiRequirements.Request.delete("/post/"+postID);
			AccountResponse.prettyPrint();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Then("Post should be deleted")
	public void post_should_be_deleted() throws Throwable {

		try {
			String response = AccountResponse.getBody().asString();
			String message = ApiRequirements.jsonStringParser(response, "result.message");
			Assert.assertEquals(message, "Post Deleted Successfully");
			System.err.println("Post deleted and validated successfully");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	//<--------------------------This framework is created by Ajith Kumar------------------------------>

}