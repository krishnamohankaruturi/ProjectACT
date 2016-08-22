import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;

public class TestReadGson {

	public static void main(String[] args) {
		
		try {
			JsonParser parser = new JsonParser();
			JsonObject obj = (JsonObject) parser.parse(new FileReader("test.json"));
			JsonArray array = obj.get("programmers").getAsJsonArray();
			for (int i = 0; i < array.size(); i++) {
				System.out.println("----------------");
				JsonObject subObject = array.get(i).getAsJsonObject();
				System.out.println("firstname = " + subObject.get("firstName").getAsString());
				System.out.println("lastname = " + subObject.get("lastName").getAsString());
				System.out.println("email = " + subObject.get("email").getAsString());
			}
			
			
			
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
