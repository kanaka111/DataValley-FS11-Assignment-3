abstract class Shape {
    
    public abstract double calculateArea();
    
    public void display() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

interface Animal {
    void sound(); 
}

interface Color {
    default void displayColor() {
        System.out.println("The color is red.");
    }
}

class Dog implements Animal, Color {
    public void sound() {
        System.out.println("Dog barks.");
    }

    public void displayColor() {
        System.out.println("The color of the dog is brown.");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.display();
        System.out.println("Area of circle: " + circle.calculateArea());

        Dog dog = new Dog();
        dog.sound();
        dog.displayColor();
    }
}