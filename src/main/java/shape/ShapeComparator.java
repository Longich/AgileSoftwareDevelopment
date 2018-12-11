package main.java.shape;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
  public int compare(Shape shape1, Shape shape2) {
    if (shape1.preceeds(shape2)) {
      return -1;
    } else {
      return 1;
    }
  }
}
