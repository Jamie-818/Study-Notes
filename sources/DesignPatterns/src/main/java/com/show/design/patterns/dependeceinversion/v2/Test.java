package com.show.design.patterns.dependeceinversion.v2;

/**
 * 演示依赖倒置原则
 *
 * @author xuanweiyao
 * @date 21:44 2019/7/22
 */
public class Test {
  /**
   * 依赖倒置原则（接口注入）演示 v2
   *
   * @author xuanweiyao
   * @date 21:19 2019/7/22
   */
  public static void main(String[] args) {
    Show show = new Show();
    show.studyImoocCourse(new JavaCourse());
    show.studyImoocCourse(new PythonCourse());
    show.studyImoocCourse(new FECourse());
    show.studyImoocCourse(new GoCourse());
  }
}
