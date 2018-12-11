package main.java.shape;

import java.util.Arrays;
import java.util.List;

public abstract class Shape {
  abstract void draw();
  abstract String getType();
  String[] a =  {"square", "circle"} ;
  private List<String> typeOrderTable = Arrays.asList("square", "circle");
  boolean preceeds(Shape shape) {
      String thisType = this.getType();
      String argType  = shape.getType();
      int thisOrd = -1;
      int argOrd  = -1;
      int ord     = 0;
      for (String tableEntry : typeOrderTable) {
          if (tableEntry.equals(thisType)) {
              thisOrd = ord;
          }
          if (tableEntry.contentEquals(argType)) {
              argOrd = ord;
          }
          if ((0 <= argOrd) && (0 <= thisOrd)) {
              break;
          }
          ord++;
      }
      return thisOrd < argOrd;
  }
  
}
