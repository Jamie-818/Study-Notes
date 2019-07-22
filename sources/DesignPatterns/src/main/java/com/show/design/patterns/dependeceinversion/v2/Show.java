package com.show.design.patterns.dependeceinversion.v2;

/**
 * 人
 *
 * @author xuanweiyao
 * @date 21:11 2019/7/22
 */
public class Show {

  /**
   * 接口注入方式 具体学习什么课程，交由上层模块选择 v2
   *
   * @author xuanweiyao
   * @date 21:17 2019/7/22
   * @param iCourse 课程接口类
   * @return void
   */
  public void studyImoocCourse(ICourse iCourse) {

    iCourse.studyCourse();
  }
}
