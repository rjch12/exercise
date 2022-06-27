package com.nuvalence.util;

public class config {
  static int xtl1;
  static int ytl1;

  static int xbl1;
  static int ybl1;

  static int xtr1;
  static int ytr1;

  static int xbr1;
  static int ybr1;

  static int xtl2;
  static int ytl2;

  static int xbl2;
  static int ybl2;

  static int xtr2;
  static int ytr2;

  static int xbr2;
  static int ybr2;

  public static void set(int XTL, int YTL, int XBL, int YBL, int XTR, int YTR, int XBR, int YBR, int seq) {
    if (seq == 1) {
      xtl1 = XTL;
      ytl1 = YTL;
      xbl1 = XBL;
      ybl1 = YBL;

      xtr1 = XTR;
      ytr1 = YTR;
      xbr1 = XBR;
      ybr1 = YBR;

    } else {

      xtl2 = XTL;
      ytl2 = YTL;
      xbl2 = XBL;
      ybl2 = YBL;

      xtr2 = XTR;
      ytr2 = YTR;
      xbr2 = XBR;
      ybr2 = YBR;
    }
  }
}