//write a progam to calculate bmi using 2d array 
import java.util.*;
public class BmiUsing2DArray{
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		int number= sc.nextInt();
		double[][] personData = new double[number][3];
		String[] weightStatus = new String[number];
		
		for(int i=0; i<number; i++){
			do{
            personData[i][0] = sc.nextDouble();
				
			}while(personData[i][0]<=0);
				
			do {
                personData[i][1] = sc.nextDouble();
            } while(personData[i][1] <= 0);
			
			personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            if(personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            }else if(personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            }else if(personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            }else {
                weightStatus[i] = "Obese";
            }

		}
		for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.println("Weight: "+personData[i][0]+" kg");
            System.out.println("Height: "+personData[i][1]+" m");
            System.out.println("BMI: "+personData[i][2]);
            System.out.println("Status: "+weightStatus[i]);
        }
	}
}