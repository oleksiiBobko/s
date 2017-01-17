package x.y.z.oop;

public class Dog extends Animal implements CanRun {

    @Override
    public void move() {
        System.out.println("run" + getClass());
    }

}
