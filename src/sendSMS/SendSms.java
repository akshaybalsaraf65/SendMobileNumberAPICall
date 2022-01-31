package sendSMS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class SendSms {
	public void sendSMs(String message,String number) throws UnsupportedEncodingException {
		System.out.println(message);
		System.out.println(number);
		try {
			String apikey = "gUw7oVJKyXiOQz9ld4HtRmTfA81c6DeFpWvYBSsbP0x2jE3GauCyPeM6Jnm4LZ7DSktaG8wc9BTiEQUb";
			String senderId = "FSTSMS";
			message = URLEncoder.encode(message, "UTF-8");
			System.out.println(message);
			String language = "english";
			String route = "q";
			String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+senderId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
			System.out.println(myUrl);
			URL url = new URL(myUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");
			System.out.println("Wait...................");
			
			int code = con.getResponseCode();
			System.out.println("Response Code : "+ code);
			
			StringBuffer response = new StringBuffer();
			BufferedReader br = new BufferedReader( new InputStreamReader(con.getInputStream()));
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				response.append(line);
			}
			System.out.println(response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		SendSms s = new SendSms();
		s.sendSMs("Hello I AM AK...."+new Date().toLocaleString(), "7738191288");
		
	}
}
