package Polymorphism;

class Shape{
    public void draw(){
        System.out.println("Draw a shape");
    }
}

class Circle extends Shape{
    @Override
    public void draw(){
        System.out.println("Draw a circle");
    }
}

class Triangle extends Shape{
     // Overriding the draw method from the Shape class
    @Override
    public void draw(){
        System.out.println("Draw a triangle");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Shape myShape;
        myShape = new Circle();
        myShape.draw();

        myShape = new Triangle();
        myShape.draw();

    }

}
