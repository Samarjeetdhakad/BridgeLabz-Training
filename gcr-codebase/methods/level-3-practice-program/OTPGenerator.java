public class OTPGenerator{

    // generate OTP
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
        }
    //check whether all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i= 0; i<otps.length; i++) {
            for (int j= i+1; j<otps.length; j++) {
                if (otps[i]==otps[j]) {
               return false; 
           }
         }
        }
        return true; 
    }
    public static void main(String[] args) {
        int[] otpArray = new int[10];
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
     }
        for(int otp: otpArray) {
            System.out.print(otp + " ");
        }
        if(areOTPsUnique(otpArray)) {
            System.out.println("All Otp are unique");
         } 
		else{
            System.out.println("Duplicate Otp found");
     }
    }
}
