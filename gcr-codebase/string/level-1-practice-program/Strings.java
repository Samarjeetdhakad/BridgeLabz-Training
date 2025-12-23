//Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
import java.util.Scanner;
public class Strings{
 public static boolean checkStrings(String a,String b){
 for(int i=0;i<a.length();i++){
	 if(a.charAt(i)!=b.charAt(i)){
	 return false;
	 }
	}
	return true;
	}
 
	 
  public static void main(String[]args){
  
  Scanner sc=new Scanner(System.in);
  String a=sc.nextLine();
  String b=sc.nextLine();
  
  boolean s=checkStrings(a,b);
  boolean res=a.equals(b);
  if(s==res){
  System.out.println("strings are equal");
  }
  else{
  System.out.println("strings are not equal");
  }
 } 
 } 