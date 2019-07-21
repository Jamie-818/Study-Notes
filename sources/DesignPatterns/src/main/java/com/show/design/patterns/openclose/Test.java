package com.show.design.patterns.openclose;

/**
 * 测试开闭原则
 *
 * @author xuanweiyao
 * @date 21:29 2019/7/21
 */
public class Test {
  public static void main(String[] args) {

    ICourse javaCourse = new JavaCourse(96, "Java设计模式", 299.00);
    System.out.println(
        "课程ID:"
            + javaCourse.getId()
            + ",课程名称:"
            + javaCourse.getName()
            + ",课程价格:"
            + javaCourse.getPrice()
            + "元");
    ICourse iCourse = new JavaDiscountCourse(96, "Java设计模式", 299.00);
    JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse) iCourse;
    System.out.println(
        "课程ID:"
            + javaDiscountCourse.getId()
            + ",课程名称:"
            + javaDiscountCourse.getName()
            + ",课程原价:"
            + javaDiscountCourse.getOriginPrce()
            + "元,课程折扣价格:"
            + javaDiscountCourse.getPrice()
            + "元");
  }
}
