package main.java.shape;

import java.awt.Point;

public abstract class Circle extends Shape{
    double itsRadius;
    Point itsCenter;
    
    @Override
    boolean preceeds(Shape shape) {
        if (shape instanceof Square) {
            return true;
        } else {
            return false;
        }
    }
   
}
