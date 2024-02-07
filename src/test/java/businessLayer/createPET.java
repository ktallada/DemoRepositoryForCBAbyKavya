package businessLayer;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import JSONRead.JSONReader;
import JSONRead.JSONWrite;


public class createPET {

	public void UploadImage(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "multipart/form-data");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
 
            // Send post request
            JSONObject test = new JSONObject();
            test.put("additionalMetadata", additionalMetadata);
            test.put("file", "filepath");
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
