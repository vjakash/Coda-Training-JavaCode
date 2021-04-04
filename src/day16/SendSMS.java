package day16;



import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;

public class SendSMS {
	public static void main(String[] args) throws UnirestException {
		HttpResponse<String> response =  Unirest.post("https://www.fast2sms.com/dev/bulkV2")
				  .header("authorization", "my_api_key")//use valid api-key
				  .header("Content-Type", "application/x-www-form-urlencoded")
				  .body("message=This%20is%20a%20test%20message&language=english&route=q&numbers=8870709119,9876543210")
				  .asString();
		//check wallet balance
//		HttpResponse<String> response =Unirest.post("https://www.fast2sms.com/dev/wallet")
//		  .header("authorization", "XgIS3hjJGHM6ce9si0m12dCWVRDZ7vbOqBfQ8nAUruawETKYk46Shp9U0twmY8TrjXPJMdIbcznqAQ5D")
//		  .asString();
		System.out.println(response.getBody());
	}
}
