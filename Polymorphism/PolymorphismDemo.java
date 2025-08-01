package Polymorphism;

class Animal{
    public void sound(){
        System.out.println("The animal makes a sound");
    }
}

class Cat extends Animal{
    @Override
    public void sound(){
        System.out.println("The cat purrs");
    }
}
class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("The dog barks");
    }
}

class Horse extends Animal{
    @Override
    public void sound(){
        System.out.println("The horse neighs");
    }
}
public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal myAnimal;

        myAnimal = new Animal();
        myAnimal.sound();

        myAnimal = new Cat();
        myAnimal.sound();

        myAnimal = new Dog();
        myAnimal.sound();

        myAnimal = new Horse();
        myAnimal.sound();
    }
}
