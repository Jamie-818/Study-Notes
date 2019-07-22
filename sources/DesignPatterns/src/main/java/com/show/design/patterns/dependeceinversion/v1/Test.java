package com.show.design.patterns.dependeceinversion.v1;
/**
 * 演示不使用依赖倒置原则时的代码
 *
 * @author xuanweiyao
 * @date 21:40 2019/7/22
 * @param
 * @return
 */
public class Test {
  /**
   * 我们如果需要学习新的课程，则需要修改用户类，非常不安全及高耦合的行为。
   *
   * @author xuanweiyao
   * @date 21:40 2019/7/22
   * @return void
   */
  public static void main(String[] args) {
    Show show = new Show();
    show.studyJavaCourse();
    show.studyPythonCourse();
  }
}
