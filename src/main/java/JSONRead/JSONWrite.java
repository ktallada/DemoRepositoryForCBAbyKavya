package JSONRead;

import static org.testng.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class  JSONWrite {
	JSONParser parser = new JSONParser();

	@SuppressWarnings("unchecked")
	public static void writeAppNumber(String appNumber) throws FileNotFoundException {
		String keyvalue = String.valueOf(Thread.currentThread().getId());
		String json = ".\\Data\\appNumber.json";

		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(json));

		JsonObject inputObj = gson.fromJson(reader, JsonObject.class);
		System.out.println(inputObj);
		JsonObject newObject = new JsonObject();

		newObject.addProperty(keyvalue, appNumber);

		if (inputObj.getAsJsonObject().has(keyvalue)) {
			System.out.println("key exists, replacing key with new value");
			inputObj.getAsJsonObject().remove(keyvalue);
			inputObj.getAsJsonObject().addProperty(keyvalue, appNumber);
		}

		else {
			System.out.println("adding new key pair");
			inputObj.getAsJsonObject().addProperty(keyvalue, appNumber);
		}

		try (FileWriter file = new FileWriter(".\\Data\\appNumber.json")) {
			file.write(inputObj.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException");
		}

		System.out.println("new key values " + inputObj);
	}

	@SuppressWarnings("unchecked")
	public static void writecaseNumber(String caseNumber) throws FileNotFoundException {

		String keyvalue = String.valueOf(Thread.currentThread().getId());
		String caseJson = ".\\Data\\FUJI\\caseNumber.json";

		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(caseJson));

		JsonObject inputObj = gson.fromJson(reader, JsonObject.class);
		System.out.println(inputObj);
		JsonObject newObject = new JsonObject();

		newObject.addProperty(keyvalue, caseNumber);

		if (inputObj.getAsJsonObject().has(keyvalue)) {
			System.out.println("key exists, replacing key with new value");
			inputObj.getAsJsonObject().remove(keyvalue);
			inputObj.getAsJsonObject().addProperty(keyvalue, caseNumber);
		}

		else {
			System.out.println("adding new key pair");
			inputObj.getAsJsonObject().addProperty(keyvalue, caseNumber);
		}

		try (FileWriter file = new FileWriter(caseJson)) {
			file.write(inputObj.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException");
		}

		System.out.println("new key values " + inputObj);

	}

	@SuppressWarnings("unchecked")
	public static void writeJSONfile(String JsonFile, String valueName, String valueOutput) {

		try {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new FileReader(JsonFile));
			JsonObject inputObj = gson.fromJson(reader, JsonObject.class);
			System.out.println(inputObj);
			JsonObject newObject = new JsonObject();

			newObject.addProperty(valueName, valueOutput);

			inputObj.getAsJsonObject().remove(valueName);
			inputObj.getAsJsonObject().addProperty(valueName, valueOutput);

			try (FileWriter file = new FileWriter(JsonFile)) {
				file.write(inputObj.toString());
				file.flush();
			} catch (IOException e) {
				e.printStackTrace();
				fail("IOException");
			}

			System.out.println("New value is" + inputObj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Test failed due to Exception");
		}
	}

	public static String editExistingJSONFile(String filePath, String arrayName, String tagName, String valueOutput) {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		String key = null;
		String finalValue = null;
		Object obj;
		
		try {
			obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;

			org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) jsonObject.get(arrayName);
			Iterator<JSONObject> iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				json = (JSONObject) iterator.next();
				Iterator<String> keys = json.keySet().iterator();
				while (keys.hasNext()) {
					key = keys.next();
					// changing from .contains to .content equals as it doesn't return an exact value
					if (key.contentEquals(tagName)) {
						json.replace(key, valueOutput);
						jsonObject.remove(arrayName);
						jsonObject.put(arrayName, jsonArray);

						try (FileWriter file = new FileWriter(filePath)) {
							String newjsonObject = jsonObject.toString();
							newjsonObject = newjsonObject.replace("\\", "");
							file.write(newjsonObject);
							file.flush();

						} catch (IOException e) {
							e.printStackTrace();
							fail("Test failed due to Exception");
						}
					}
				}
			}
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
			fail("Test failed due to Exception");
		}
		return finalValue;
	}
}