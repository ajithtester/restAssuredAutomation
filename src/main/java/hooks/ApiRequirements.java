package hooks;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.http.cookie.SetCookie;
import org.testng.annotations.BeforeClass;

import excelRead.ReadTestData;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class ApiRequirements extends ReadTestData{

	public static String BaseURI = "https://api-test.freeu.vn/api/";
	public static RequestSpecification Request;
	public static String Content_Type;
	public static String Content_Value;
	public static String postNewAccount;
	public static String changePassword;
	public static String postLogin;
	
	public static String Authorise;

	@Before
	public static void apiValues() throws Throwable {

		Content_Type = 	readTestData(1, 1, AccountCreation) ;
		Content_Value = readTestData(1, 2, AccountCreation);
		postNewAccount = readTestData(1, 3, AccountCreation);
		postLogin = readTestData(1, 3, LoginAccount);
		changePassword = readTestData(1, 3, ChangePassword);
		Authorise = "Authorization";

		PrintStream Logs = new PrintStream("./logs/Logs.txt");
				RestAssured.baseURI = ApiRequirements.BaseURI;
				Request =	RestAssured.given();
				Request.header(ApiRequirements.Content_Type, ApiRequirements.Content_Value);

//		Request = new RequestSpecBuilder().
//				setBaseUri(ApiRequirements.BaseURI).setContentType(ContentType.JSON).
//				addFilter(RequestLoggingFilter.logRequestTo(Logs)).build();

	}

	public static String jsonStringParser(String response, String Key) {

		return	 JsonPath.from(response).getString(Key);
	}


	public static int jsonIntParser(String response, String Key) {

		return	 JsonPath.from(response).getInt(Key);
	}
}
