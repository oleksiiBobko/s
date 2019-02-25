package x.y.z;

import java.util.List;

public class Calculator extends MyBean implements Calculatable {
    
    public static final String EMPTY = "";
    
    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public Object method(String o) throws Throwable {
        return null;
    }

    @Override
    public void calculate(String o) {
          char[] car = new char[4];
          car[0] = 'r';
          char[] car1 = car.clone();
//        return null;
    }

}
