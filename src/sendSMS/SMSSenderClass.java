package sendSMS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMSSenderClass {

	public static void main(String[] args) {
		
		try {
			//  Construct data
			String apiKey = "apikey=" + "NmMzYjE4YjI0ODU0MjI2ZmNkNDcxYjYxMmE5MGQ4NTc=";
			String message = "&message=" + "First program to send local system to message!";
			String sender = "&sender=" + "AKI";
			String numbers = "&numbers=" + "7738191288";
			
			// send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer stringbuffer = new StringBuffer();
			String line;
			while((line = rd.readLine()) != null ) {
				stringbuffer.append(line).append("\n");
			}
			System.out.println(stringbuffer.toString());
			rd.close();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

}
