public class DigitalWatch{
	public static void main(String args[]){
		
		for(int i=0; i<24; i++){
			for(int j=0; j<60; j++){
				if(i==13){
					break;
				}
				System.out.println("Hour : "+ i + " minute : "+ j);
			}
			if(i==13){
					break;
			}
			
		}
		
	}
}