package com.show.design.patterns.openclose;

/**
 * java课程类
 *
 * @author xuanweiyao
 * @date 21:27 2019/7/21
 */
public class JavaCourse implements ICourse {
  private Integer Id;
  private String name;
  private Double price;

  public JavaCourse(Integer id, String name, Double price) {

    this.Id = id;
    this.name = name;
    this.price = price;
  }

  /** 获取课程ID */
  @Override
  public Integer getId() {

    return this.Id;
  }

  /** 获取课程清楚 */
  @Override
  public String getName() {

    return this.name;
  }

  /** 获取课程价格 */
  @Override
  public Double getPrice() {

        return this.price;
    }
}
