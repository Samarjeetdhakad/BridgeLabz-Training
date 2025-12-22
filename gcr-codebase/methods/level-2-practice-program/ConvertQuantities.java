import java.util.Scanner;
public class ConvertQuantities {
      public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }
    // Method to Convert Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
   }
    // Method to Convert Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
     }
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
     }
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
      }
  
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
   }

    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
        double fahrenheit = sc.nextDoule();
        double celsius= sc.nextDoule();
        double pounds  = sc.nextDoule();
        double kilograms  = sc.nextDoule();
        double gallons = sc.nextDoule();
        double liters =sc.nextDoule();
        
        System.out.println(fahrenheit + "°F = " + convertFahrenheitToCelsius(fahrenheit) + "°C");
        System.out.println(celsius + "°C = " + convertCelsiusToFahrenheit(celsius) + "°F");
        System.out.println(pounds + " lbs = " + convertPoundsToKilograms(pounds) + " kg");
        System.out.println(kilograms + " kg = " + convertKilogramsToPounds(kilograms) + " lbs");
        System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");
        System.out.println(liters + " liters = " + convertLitersToGallons(liters) + " gallons");
  }
}