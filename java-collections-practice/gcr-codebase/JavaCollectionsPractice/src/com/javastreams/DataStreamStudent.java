package com.javastreams;
import java.io.*;

public class DataStreamStudent{
	public static void main(String[] args){
		String file = "D:\\java programming workspace\\java-collections-practice\\gcr-codebase\\JavaCollectionsPractice\\src\\com\\javastreams\\outputfile\\studentDetails.txt";		
		try( DataOutputStream dos = new DataOutputStream(new FileOutputStream(file)))
		{
			dos.writeInt(102);
			dos.writeUTF("samarjeet dhakad");
			dos.writeDouble(8.75);			
			 System.out.println("Student data written successfully");			
		} catch (IOException e) {
            e.printStackTrace();
        }	
		try ( DataInputStream dis = new DataInputStream(new FileInputStream(file))){
			int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nStudent Details:");
            System.out.println("Roll No: " + rollNo);
            System.out.println("Name   : " + name);
            System.out.println("GPA    : " + gpa);
		} 
		catch (IOException e){
            e.printStackTrace();
        }	
	}
}