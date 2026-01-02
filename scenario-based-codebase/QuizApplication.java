import java.util.*;


public class QuizApplication{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String[] ques = {"The value of 2+3 is A) 4, B) 6, c)5 , D) 10 ", 
						 "The value of 2*3 A) 4, B) 6, c)5 , D) 10 ",
						 "The value of 23*8 A) 184, B) 186, c)195 , D) 210 ",
						 "The value of 21/7 = A) 4, B) 6, c)3 , D) 10", 
						 "The value of 23-3 A) 20, B) 16, c)15 , D) 10",
						};
		int score =0;
		char[] ansArr = {'C','B','A','C','A'};
		for(int i=0; i<ques.length; i++){
			System.out.println(ques[i]);
			System.out.println("Enter the ans (A/B/C/D) ");
			char ans = sc.next().toUpperCase().charAt(0);
			
			switch(ans){
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				if(ans == ansArr[i]){
					score++;
				}
				break;
				
				default :
				System.out.println("Invalid option !");
			}
			System.out.println();
			
		}
		System.out.println("Quiz completed ");
		System.out.println("Score is : " + score);
		
		
		
		
		
		
	}
}