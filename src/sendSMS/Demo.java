package sendSMS;

public class Demo {

	public static String generateOTP() {
		int ramdomNo = (int) (Math.random()*9000)+1000;
		String otp = String.valueOf(ramdomNo);
		return otp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String otpStr = generateOTP();
		System.out.println("OTP: "+otpStr);
	}

}
