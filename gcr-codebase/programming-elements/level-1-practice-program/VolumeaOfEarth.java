import java.util.*;
// finding volume of earth 
public class VolumeaOfEarth{
public static void main(String[]args){

 double radiusKm = 6378;
 double volumeKm = (4/3)* Math.PI *radiusKm*radiusKm*radiusKm;
 double radiusMiles = radiusKm*1.06;
 double volumeMiles = (4/3)*Math.PI*Math.pow(radiusMiles,3);
 
 //displaying the output
 System.out.println("The volume of earth in cubic kilometers is" + volumeKm + "and cubic miles is " + volumeMiles);
}
}