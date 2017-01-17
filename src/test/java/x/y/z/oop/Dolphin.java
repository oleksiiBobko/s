package x.y.z.oop;

import x.y.z.Swimmable;

public class Dolphin extends Animal implements Swimmable {

    @Override
    public void move() {
        System.out.println("swim" + getClass());
    }

}
