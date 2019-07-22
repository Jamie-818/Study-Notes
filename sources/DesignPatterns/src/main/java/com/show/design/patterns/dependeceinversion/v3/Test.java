package com.show.design.patterns.dependeceinversion.v3;

public class Test {
  /**
   * 依赖倒置原则（依赖注入）演示 v3
   *
   * @author xuanweiyao
   * @date 21:34 2019/7/22
   * @return void
   */
  public static void main(String[] args) {
    Show show1 = new Show(new JavaCourse());
    show1.studyImoocCourse();
    Show show2 = new Show(new PythonCourse());
    show2.studyImoocCourse();
  }
}
