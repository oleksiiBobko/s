package x.y.z.oop;

public abstract class Animal {
    
    public void breathe() {
        System.out.println("breathe" + getClass());
    }
    
    public abstract void move(); 
    
}
