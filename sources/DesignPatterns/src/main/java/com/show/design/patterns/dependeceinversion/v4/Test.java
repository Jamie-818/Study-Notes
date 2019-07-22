package com.show.design.patterns.dependeceinversion.v4;

public class Test {
  /**
   * 依赖倒置原则（set注入）演示 v4
   *
   * @author xuanweiyao
   * @date 21:34 2019/7/22
   * @return void
   */
  public static void main(String[] args) {
    Show show = new Show();
    show.setiCourse(new JavaCourse());
    show.studyImoocCourse();
    show.setiCourse(new PythonCourse());
    show.studyImoocCourse();
  }
}
