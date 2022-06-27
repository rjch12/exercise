package com.nuvalence;

import java.util.HashSet;
import java.util.Set;

import com.nuvalence.util.rectangle;
import com.nuvalence.util.rectangle.coordinates;

public class validateFeatures {
  public boolean validateIntersection(rectangle r1, rectangle r2) {
    // check if any line from coordinate points of rect one is intersected
    // by any another line of rectangle two
    if (intersect(r1.tl, r1.bl, r2.tl, r2.bl) ||
        intersect(r1.tl, r1.bl, r2.tr, r2.br) ||
        intersect(r1.tl, r1.bl, r2.tl, r2.tr) ||
        intersect(r1.tl, r1.bl, r2.bl, r2.br) ||

        intersect(r1.tr, r1.br, r2.tl, r2.bl) ||
        intersect(r1.tr, r1.br, r2.tr, r2.br) ||
        intersect(r1.tr, r1.br, r2.tl, r2.tr) ||
        intersect(r1.tr, r1.br, r2.bl, r2.br) ||

        intersect(r1.bl, r1.br, r2.tl, r2.bl) ||
        intersect(r1.bl, r1.br, r2.tr, r2.br) ||
        intersect(r1.bl, r1.br, r2.tl, r2.tr) ||
        intersect(r1.bl, r1.br, r2.bl, r2.br) ||

        intersect(r1.tl, r1.tr, r2.tl, r2.bl) ||
        intersect(r1.tl, r1.tr, r2.tr, r2.br) ||
        intersect(r1.tl, r1.tr, r2.tl, r2.tr) ||
        intersect(r1.tl, r1.tr, r2.bl, r2.br)) {
      return true;
    } else {
      return false;
    }
  }

  boolean validateContainment(rectangle r1, rectangle r2) {
    if (oneContainsTwo(r1, r2) || oneContainsTwo(r2, r1)) {
      return true;
    } else {
      return false;
    }
  }

  boolean oneContainsTwo(rectangle r1, rectangle r2) {
    // check if all points of r2 lies within r1.
    // verify x

    if (contains(r1.tl, r1.bl, r1.tr, r1.br, r2.tl) &&
        contains(r1.tl, r1.bl, r1.tr, r1.br, r2.bl) &&
        contains(r1.tl, r1.bl, r1.tr, r1.br, r2.br) &&
        contains(r1.tl, r1.bl, r1.tr, r1.br, r2.tr) ) {
      return true;
    } else {
      return false;
    }
  }

  String validateAdjacency(rectangle r1, rectangle r2) {
    // validate is rectangles are sub-line adjacent.
    if (checkSublineAdjacent(r1, r2) == 1 || checkSublineAdjacent(r2, r1) == 1)
      return "Adjacent(Sub-line)";

    // validate if rectangles are proper adjacent.
    if (properAdjacent(r1, r2) || properAdjacent(r2, r1))
      return "Adjacent(Proper)";

    // validate if rectangles are partial adjacent.
    if (partialAdjacent(r1, r2) == 1 || partialAdjacent(r2, r1) == 1)
      return "Adjacent(Parital)";
    // since no adjacency could be established, the given rectangles are not
    // adjacent.
    return "not adjacent";
  }

  boolean properAdjacent(rectangle r1, rectangle r2) {
    if (getCommonPointScore(r1, r2) == 2)
      return true;
    return false;
  }

  int checkSublineAdjacent(rectangle r1, rectangle r2) {

    int colinearPoints = 0;
    // check if top-left point of rectangle 2 lies on any of the 4 boundries of
    // rectangle 1
    if (online(r1.tl, r1.bl, r2.tl) || online(r1.bl, r1.tl, r2.tl) ||
        online(r1.tr, r1.br, r2.tl) || online(r1.br, r1.tr, r2.tl) ||
        online(r1.bl, r1.br, r2.tl) || online(r1.br, r1.bl, r2.tl) ||
        online(r1.tl, r1.tr, r2.tl) || online(r1.tr, r1.tl, r2.tl)) {
      colinearPoints++;
    }

    // check if top-right point of rectangle 2 lies on any of the 4 boundries of
    // rectangle 1
    if (online(r1.tl, r1.bl, r2.tr) || online(r1.bl, r1.tl, r2.tr) ||
        online(r1.tr, r1.br, r2.tr) || online(r1.br, r1.tr, r2.tr) ||
        online(r1.bl, r1.br, r2.tr) || online(r1.br, r1.bl, r2.tr) ||
        online(r1.tl, r1.tr, r2.tr) || online(r1.tr, r1.tl, r2.tr)) {
      colinearPoints++;
    }

    // check if bottom-left point of rectangle 2 lies on any of the 4 boundries of
    // rectangle 1
    if (online(r1.tl, r1.bl, r2.bl) || online(r1.bl, r1.tl, r2.bl) ||
        online(r1.tr, r1.br, r2.bl) || online(r1.br, r1.tr, r2.bl) ||
        online(r1.bl, r1.br, r2.bl) || online(r1.br, r1.bl, r2.bl) ||
        online(r1.tl, r1.tr, r2.bl) || online(r1.tr, r1.tl, r2.bl)) {
      colinearPoints++;
    }

    // check if bottom-right point of rectangle 2 lies on any of the 4 boundries of
    // rectangle 1
    if (online(r1.tl, r1.bl, r2.br) || online(r1.bl, r1.tl, r2.br) ||
        online(r1.tr, r1.br, r2.br) || online(r1.br, r1.tr, r2.br) ||
        online(r1.bl, r1.br, r2.br) || online(r1.br, r1.bl, r2.br) ||
        online(r1.tl, r1.tr, r2.br) || online(r1.tr, r1.tl, r2.br)) {
      colinearPoints++;
    }
    return colinearPoints;
  }

  int partialAdjacent(rectangle r1, rectangle r2) {

    int colinearPoints = 0;
    // check if top-left point of rectangle 2 lies on any of the 4 boundries of
    // rectangle 1
    if (online(r1.tl, r2.tl, r1.bl) || online(r1.bl, r2.tl, r1.tl) ||
        online(r1.tr, r2.tl, r1.br) || online(r1.br, r2.tl, r1.tr) ||
        online(r1.bl, r2.tl, r1.br) || online(r1.br, r2.tl, r1.bl) ||
        online(r1.tl, r2.tl, r1.tr) || online(r1.tr, r2.tl, r1.tl)) {
      colinearPoints++;
    }

    // check if top-right point of rectangle 2 lies on any of the 4 boundries of
    // rectangle 1
    if (online(r1.tl, r2.tr, r1.bl) || online(r1.bl, r2.tr, r1.tl) ||
        online(r1.tr, r2.tr, r1.br) || online(r1.br, r2.tr, r1.tr) ||
        online(r1.bl, r2.tr, r1.br) || online(r1.br, r2.tr, r1.bl) ||
        online(r1.tl, r2.tr, r1.tr) || online(r1.tr, r2.tr, r1.tl)) {
      colinearPoints++;
    }

    // check if bottom-left point of rectangle 2 lies on any of the 4 boundries of
    // rectangle 1
    if (online(r1.tl, r2.bl, r1.bl) || online(r1.bl, r2.bl, r1.tl) ||
        online(r1.tr, r2.bl, r1.br) || online(r1.br, r2.bl, r1.tr) ||
        online(r1.bl, r2.bl, r1.br) || online(r1.br, r2.bl, r1.bl) ||
        online(r1.tl, r2.bl, r1.tr) || online(r1.tr, r2.bl, r1.tl)) {
      colinearPoints++;
    }

    // check if bottom-right point of rectangle 2 lies on any of the 4 boundries of
    // rectangle 1
    if (online(r1.tl, r2.br, r1.bl) || online(r1.bl, r2.br, r1.tl) ||
        online(r1.tr, r2.br, r1.br) || online(r1.br, r2.br, r1.tr) ||
        online(r1.bl, r2.br, r1.br) || online(r1.br, r2.br, r1.bl) ||
        online(r1.tl, r2.br, r1.tr) || online(r1.tr, r2.br, r1.tl)) {
      colinearPoints++;
    }
    return colinearPoints;
  }

  int getCommonPointScore(rectangle r1, rectangle r2) {
    int score = 0;
    Set<coordinates> hs = new HashSet<>();
    hs.add(r1.tl);
    hs.add(r1.bl);
    hs.add(r1.tr);
    hs.add(r1.br);

    if (hs.contains(r2.tl))
      score++;
    if (hs.contains(r2.tr))
      score++;
    if (hs.contains(r2.bl))
      score++;
    if (hs.contains(r2.br))
      score++;

    return score;
  }

  boolean intersect(coordinates a, coordinates b, coordinates c, coordinates d) {
    // Find the four orientations needed for general and special cases
    int o1 = orientation(a, b, c);
    int o2 = orientation(a, b, d);
    int o3 = orientation(c, d, a);
    int o4 = orientation(c, d, b);

    if (o1 != o2 && o3 != o4)
      return true;

    // a, b and c are collinear and c lies on segment ab
    if (o1 == 0 && online(a, c, b))
      return true;

    // a, b and d are collinear and d lies on segment ab
    if (o2 == 0 && online(a, d, b))
      return true;

    // c, d and a are collinear and a lies on segment cd
    if (o3 == 0 && online(c, a, d))
      return true;

    // c, d and b are collinear and b lies on segment cd
    if (o4 == 0 && online(c, b, d))
      return true;

    return false; // Doesn't fall in any of the above cases

  }

  int orientation(coordinates p, coordinates q, coordinates r) {
    int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    if (val == 0)
      return 0;
    return (val > 0) ? 1 : 2;
  }

  boolean online(coordinates p, coordinates q, coordinates r) {
    // check if q lies on line pr
    if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
        q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
      return true;
    return false;
  }

  float area(int x1, int y1, int x2,
      int y2, int x3, int y3) {
    return (float) Math.abs((x1 * (y2 - y3) +
        x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
  }

  boolean contains(coordinates A, coordinates B, coordinates C, coordinates D, coordinates p) {

    // Calculate area of rectangle ABCD
    float Area = Math.max(A.x, B.x) * Math.max(A.y, C.y);

    // Calculate area of triangle PAB
    float A1 = area(p.x, p.y, A.x, A.y, B.x, B.y);

    // Calculate area of triangle PBC
    float A2 = area(p.x, p.y, B.x, B.y, C.x, C.y);

    // Calculate area of triangle PCD
    float A3 = area(p.x, p.y, C.x, C.y, D.x, D.y);

    // Calculate area of triangle PAD
    float A4 = area(p.x, p.y, A.x, A.y, D.x, D.y);

    // Check if sum of A1, A2, A3 and A4 is same as A

    return (Area == A1 + A2 + A3 + A4);
  }

}