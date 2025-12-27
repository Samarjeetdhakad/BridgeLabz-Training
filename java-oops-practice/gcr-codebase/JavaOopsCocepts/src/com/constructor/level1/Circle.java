package com.constructor.level1;

class Circle {

    private double radius;

    Circle() {
        this.radius = 1.0;  
    }
    
   Circle(double radius) {
        this.radius=radius;
    }
    double calculateArea() {
        return Math.PI*radius*radius;
    }

    void display() {
        System.out.println("Radius: "+radius);
        System.out.println("Area: "+calculateArea());
    }

    public static void main(String[] args) {
        Circle c1=new Circle();       
        Circle c2=new Circle(5.0);   
        System.out.println("Circle 1:");
        c1.display();
        System.out.println("\nCircle 2:");
        c2.display();
    }
}
