package com.constructor.level1;

public class CourseMain {
	
	    public static void main(String[] args) {

	        Course c1=new Course("Java Full Stack",6,75000);
	        Course c2=new Course("Data Analytics",5,65000);

	        c1.displayCourseDetails();
	        c2.displayCourseDetails();
	        
	        Course.updateInstituteName("\n BridgeLabz Solutions");

	        c1.displayCourseDetails();
	        c2.displayCourseDetails();
	    }
	}


