package swaggerUi_modules;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import excelRead.ReadTestData;

public class ApiRequestBody extends ReadTestData {

	public static void main(String[] args) throws Throwable {
		changePassword();
	}

	public static JSONObject newAccountInputs() throws Throwable {

		JSONObject input = new JSONObject();
		input.put(readTestData(1, 4, AccountCreation), readTestData(1, 5, AccountCreation));
		input.put(readTestData(2, 4, AccountCreation), readTestData(2, 5, AccountCreation));
		input.put(readTestData(3, 4, AccountCreation), readTestData(3, 5, AccountCreation));
		input.put(readTestData(4, 4, AccountCreation), readTestData(4, 5, AccountCreation));
		input.put(readTestData(5, 4, AccountCreation), readTestData(5, 5, AccountCreation));
		input.put(readTestData(6, 4, AccountCreation), readTestData(6, 5, AccountCreation));
		input.put(readTestData(7, 4, AccountCreation), readTestData(7, 5, AccountCreation));
		input.put(readTestData(8, 4, AccountCreation), readTestData(8, 5, AccountCreation));
		input.put(readTestData(9, 4, AccountCreation), readTestData(9, 5, AccountCreation));
		//System.out.println(input);
		return input;

	}
	
	public static JSONObject loginInputs() throws Throwable {
		
		JSONObject input = new JSONObject();
		input.put(readTestData(1, 4, LoginAccount), readTestData(1, 5, LoginAccount));
		input.put(readTestData(2, 4, LoginAccount), readTestData(2, 5, LoginAccount));
		input.put(readTestData(3, 4, LoginAccount), readTestData(3, 5, LoginAccount));
		input.put(readTestData(4, 4, LoginAccount), readTestData(4, 5, LoginAccount));
		//System.out.println(input);
		return input;
		
	}
	
	public static JSONObject changePassword() throws Throwable {
		
		JSONObject input = new JSONObject();
		input.put(readTestData(1, 4, ChangePassword), readTestData(1, 5, ChangePassword));
		input.put(readTestData(2, 4, ChangePassword), readTestData(2, 5, ChangePassword));
		input.put(readTestData(3, 4, ChangePassword), readTestData(3, 5, ChangePassword));
		//System.out.println(input);
		return input;
	}
	
	public static String createPost() throws Throwable {
		
		return "{\r\n"
				+ "\"task_title\": \"clean room 12\",\r\n"
				+ "\"task_description\": \"need to clean the room and hall kitchen etc\",\r\n"
				+ "\"task_location\": \"chennai\",\r\n"
				+ "\"task_type\": \"in_person\",\r\n"
				+ "\"budget_type\": \"total\",\r\n"
				+ "\"hours_to_complete\": 10,\r\n"
				+ "\"total_budget\": 200000,\r\n"
				+ "\"scheduled_date\": \"09-09-2019\",\r\n"
				+ "\"scheduled_time\": \"10:00 AM\",\r\n"
				+ "\"category_id\": 1,\r\n"
				+ "\"payment_type\": \"cash\",\r\n"
				+ "\"task_attachments\": [\r\n"
				+ "{\r\n"
				+ "\"file_url\": \"posts/cleam_room1.png\",\r\n"
				+ "\"file_type\": \"JPG\",\r\n"
				+ "\"keyname\": \"cleanroom\"\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"file_url\": \"posts/cleam_room2.png\",\r\n"
				+ "\"file_type\": \"JPG\",\r\n"
				+ "\"keyname\": \"cleanroom\"\r\n"
				+ "}\r\n"
				+ "],\r\n"
				+ "\"task_things\": [\r\n"
				+ "\"machine\",\r\n"
				+ "\"tools\"\r\n"
				+ "],\r\n"
				+ "\"latitude\": 11.1271,\r\n"
				+ "\"longitude\": 78.6569\r\n"
				+ "}";
	}
	
	
	
}
	
	
//	public static JSONObject editInputs() throws Throwable {
//		
//		JSONObject input = new JSONObject();
//		
//		JSONArray arrayvalue = new JSONArray();
//		input.put(readTestData(9, 3, "EditAccount"), excelread(9, 4, "CreatePost"));
//		arrayvalue.add(input);
//		
//		
//		input.put(readTestData(1, 4, EditAccount), readTestData(1, 5, EditAccount));
//		input.put(readTestData(2, 4, EditAccount), readTestData(2, 5, EditAccount));
//		input.put(readTestData(3, 4, EditAccount), readTestData(3, 5, EditAccount));
//		input.put(readTestData(4, 4, EditAccount), readTestData(4, 5, EditAccount));
//		input.put(readTestData(5, 4, EditAccount), readTestData(5, 5, EditAccount));
//		input.put(readTestData(6, 4, EditAccount), readTestData(6, 5, EditAccount));
//		input.put(readTestData(7, 4, EditAccount), readTestData(7, 5, EditAccount));
//		input.put(readTestData(8, 4, EditAccount), readTestData(8, 5, EditAccount));
//		input.put(readTestData(9, 4, EditAccount), readTestData(9, 5, EditAccount));
//		input.put(readTestData(10, 4, EditAccount), readTestData(10, 5, EditAccount));
//		input.put(readTestData(11, 4, EditAccount), readTestData(11, 5, EditAccount));
//		input.put(readTestData(12, 4, EditAccount), readTestData(12, 5, EditAccount));
//		input.put(readTestData(13, 4, EditAccount), readTestData(13, 5, EditAccount));
//		input.put(readTestData(14, 4, EditAccount), readTestData(14, 5, EditAccount));
//		input.put(readTestData(15, 4, EditAccount), readTestData(15, 5, EditAccount));
//		System.out.println(input);
//		return input;
//	}
//}
