package com.lambdaexpression.smarthomelightining; 

public class Main {
	    public static void main(String[] args) {
	        SmartLightController controller=new SmartLightController();
	        controller.addAction("motion", () -> System.out.println(" Lights on full brightness"));
	        controller.addAction("night", () -> System.out.println(" Lights set to warm mode"));
	        controller.addAction("voice", () ->System.out.println(" Lights set to party mode "));
	        controller.execute("motion");
	        controller.execute("night");
	        controller.execute("voice");
	    }
	}

