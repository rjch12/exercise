package com.nuvalence.util;

public class rectangle {
  public class coordinates {
    public int x, y;

    public coordinates(int xCoordinate, int yCoordinate) {
      this.x = xCoordinate;
      this.y = yCoordinate;
    }
  }

  public coordinates tl;
  public coordinates bl;
  public coordinates tr;
  public coordinates br;

  public rectangle(int xtl, int ytl,
      int xbl, int ybl,
      int xtr, int ytr,
      int xbr, int ybr) {

    this.tl = new coordinates(xtl, ytl);
    this.bl = new coordinates(xbl, ybl);
    this.tr = new coordinates(xtr, ytr);
    this.br = new coordinates(xbr, ybr);
  }
}
