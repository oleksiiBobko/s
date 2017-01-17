package x.y.z.oop;

import x.y.z.Swimmable;

public class Main {

    public static void main(String[] args) {
        
        Animal dog = new Dog();
        Animal dolphin = new Dolphin();
        
//        dog.breathe();
//        dog.move();
//        
//        dolphin.breathe();
//        dolphin.move();
        
        System.out.println(dolphin instanceof Animal);
        
//        name(dolphin);
//        
//        name(dog);

    }
    
    private static void name(Animal a) {
        a.move();
    }
    
}
