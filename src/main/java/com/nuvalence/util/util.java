package com.nuvalence.util;

public class util {
  public rectangle getRectangle(int seq) {
    if (seq > 2) {
      throw new IllegalArgumentException();
    }

    if (seq == 1) {
      return new rectangle(config.xtl1, config.ytl1, config.xbl1, config.ybl1,
          config.xtr1, config.ytr1, config.xbr1, config.ybr1);
    } else {
      return new rectangle(config.xtl2, config.ytl2, config.xbl2, config.ybl2,
          config.xtr2, config.ytr2, config.xbr2, config.ybr2);
    }
  }
}
