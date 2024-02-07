package businessLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import JSONRead.JSONReader;
import JSONRead.JSONWrite;


public class findPET {

	public void getPETByStatus(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
            //add reuqest header
            con.setRequestMethod("GET");
	    con.setRequestProperty("authorization", "Bearer dba985d4-d480-41fc-8e90-865478a3f232");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
 
            // Send get request
            JSONObject test = new JSONObject();
            test.put("Status", Status);
            String jsonInputString = test.toString();
            System.out.println(jsonInputString);
            System.out.println("Response:" + returnResponse(con, jsonInputString));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Found PET");
    }
 
	public void getPETById(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
            //add reuqest header
            con.setRequestMethod("GET");
	    con.setRequestProperty("authorization", "Bearer dba985d4-d480-41fc-8e90-865478a3f232");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
 
            // Send get request
            JSONObject test = new JSONObject();
            test.put("Id", Id);
	    String jsonInputString = test.toString();
            System.out.println(jsonInputString);
            System.out.println("Response:" + returnResponse(con, jsonInputString));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Found PET");
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
