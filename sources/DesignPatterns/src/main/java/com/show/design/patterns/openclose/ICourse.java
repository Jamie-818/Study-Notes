package com.show.design.patterns.openclose;

/**
 * 课程接口
 *
 * @author xuanweiyao
 * @date 21:24 2019/7/21
 */
public interface ICourse {
  /** 获取课程ID */
  Integer getId();
  /** 获取课程清楚 */
  String getName();
  /** 获取课程价格 */
  Double getPrice();
}
