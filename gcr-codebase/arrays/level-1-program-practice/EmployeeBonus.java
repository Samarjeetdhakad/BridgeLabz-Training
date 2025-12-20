//Write a program to find the bonus of 10 employees beased on their years of experience and the total bonus amount thst company have to pay for all the employees
import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
		
		//create scanner object and take input 
        Scanner sc=new Scanner(System.in);   
        double[] salary=new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus=new double[10];
        double[] newSalary=new double[10];
        double totalBonus=0.0;
        double totalOldSalary=0.0;
        double totalNewSalary=0.0;
    
	    //calculating the salary of the employees
        for (int i=0;i<10;i++) {
            double sal=sc.nextDouble();
            double years= sc.nextDouble();         
            if (sal<=0||years<0) {
                System.out.println("Invalid input");
                i--; 
                continue;
            }
            salary[i]=sal;
            yearsOfService[i]=years;
        }
 
        for (int i=0; i<10;i++) {
            if (yearsOfService[i]>5) {
                bonus[i]=salary[i]*0.05; 
            } else {
                bonus[i]=salary[i]*0.02; 
            }
            newSalary[i]=salary[i]+bonus[i];
          
            totalBonus+=bonus[i];
            totalOldSalary +=salary[i];
            totalNewSalary +=newSalary[i];
        }
// showing the output of the salary and bonus
        System.out.println(" Employee Bonus Details ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee "+(i+1)+" | Old Salary: "+ salary[i]+" | Bonus: " +bonus[i]+" | New Salary: "+newSalary[i]);
        }
        System.out.println("Company Summary");
        System.out.println("Total Old Salary"+totalOldSalary);
        System.out.println("Total Bonus Payout"+totalBonus);
        System.out.println("Total New Salary"+totalNewSalary);
    }
}
