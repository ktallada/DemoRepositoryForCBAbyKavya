package businessLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import JSONRead.JSONReader;
import JSONRead.JSONWrite;


public class updatePET {

	public void UpdateExistingPET(String url, String jsonfilepath) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		String payload = "jsonfilepath";
 
            //add reuqest header
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json, utf-8");
            con.setRequestProperty("Accept", "application/json");
	     con.setRequestProperty("authorization", "Bearer dba985d4-d480-41fc-8e90-865478a3f232");
            con.setDoOutput(true);
 
            // Send put request
            JSONObject test = new JSONObject();
            test.put("body", payload);
	    String jsonInputString = test.toString();
            System.out.println(jsonInputString);
            System.out.println("Response:" + returnResponse(con, jsonInputString));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("File Uploaded");
    }
 
public void updatePetByFormData(String url, String Jsonfilepath) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		String payload = "jsonfilepath";
 
            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json, utf-8");
            con.setRequestProperty("Accept", "application/json");
	     con.setRequestProperty("authorization", "Bearer dba985d4-d480-41fc-8e90-865478a3f232");
            con.setDoOutput(true);
 
            // Send put request
            JSONObject test = new JSONObject();
            test.put("body", payload);
	    String jsonInputString = test.toString();
            System.out.println(jsonInputString);
            System.out.println("Response:" + returnResponse(con, jsonInputString));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("File Uploaded");
    }

    public String returnResponse(HttpURLConnection con, String jsonInputString) {
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (Exception e) {
            System.out.println(e);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        } catch (Exception e) 
		{
            System.out.println("Couldnt read response from URL");
            System.out.println(e);
            return null;
       		 }
    }
	
}
