import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class createJson {

	public static void main(String[] args)
	{
		JsonObject obj = new JsonObject();
		JsonArray array = new JsonArray();
		
		JsonObject programmers1 = new JsonObject();
		programmers1.addProperty("firstName", "Brett");
		programmers1.addProperty("lastName", "McLaughlin");
		programmers1.addProperty("email", "aaaa");
		array.add(programmers1);
		
		JsonObject programmers2 = new JsonObject();
		programmers2.addProperty("firstName", "Jason");
		programmers2.addProperty("lastName", "Hunter");
		programmers2.addProperty("email", "bbb");
		array.add(programmers2);
		
		JsonObject programmers3 = new JsonObject();
		programmers3.addProperty("firstName", "Lee");
		programmers3.addProperty("lastName", "Bruce");
		programmers3.addProperty("email", "ccc");
		array.add(programmers3);
		
		obj.add("programmers",array);

		System.out.println(obj.toString());
	}
}
