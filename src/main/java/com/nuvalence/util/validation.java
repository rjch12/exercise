package com.nuvalence.util;

public class validation {
  public validation() {
  }

  public static boolean validateRectangles(rectangle rect1, rectangle rect2) {

    // Validate dimensions of the given two rectangles.
    if (rect1.tl == null
        || rect1.bl == null
        || rect1.tr == null
        || rect1.br == null

        || rect2.tl == null
        || rect2.bl == null
        || rect2.tr == null
        || rect2.br == null) {
      return false;
    }
    return true;
  }
}
