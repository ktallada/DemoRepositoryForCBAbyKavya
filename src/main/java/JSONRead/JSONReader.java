package JSONRead;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class JSONReader {
	JSONParser parser = new JSONParser();

	public String jsonRead(String filePath, String tagName) throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader(filePath));
		JSONObject jsonObject = (JSONObject) obj;
		return (String) jsonObject.get(tagName);
	}

	public String jsonReadArray(String filePath, String arrayName, String tagName)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		String key = null;
		String finalValue = null;
		Object obj = parser.parse(new FileReader(filePath));
		JSONObject jsonObject = (JSONObject) obj;
		org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) jsonObject.get(arrayName);
		Iterator<JSONObject> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			json = (JSONObject) iterator.next();
			Iterator<String> keys = json.keySet().iterator();
			while (keys.hasNext()) {
				key = keys.next();

				//changing from .contains to .contentequals as it doesnt return an exact value
				if (key.contentEquals(tagName)) {
					finalValue = (String) json.get(key);
				}
			}
		}
		return finalValue;
	}

}

