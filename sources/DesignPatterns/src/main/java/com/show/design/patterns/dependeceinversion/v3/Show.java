package com.show.design.patterns.dependeceinversion.v3;

/**
 * 人
 *
 * @author xuanweiyao
 * @date 21:11 2019/7/22
 */
public class Show {
  private ICourse iCourse;

  /**
   * 构造器注入
   *
   * @author xuanweiyao
   * @date 21:32 2019/7/22
   * @param iCourse 课程接口类
   * @return
   */
  public Show(ICourse iCourse) {

    this.iCourse = iCourse;
  }
  /**
   * 依赖器注入方法
   *
   * @author xuanweiyao
   * @date 21:33 2019/7/22
   * @return void
   */
  public void studyImoocCourse() {

    iCourse.studyCourse();
  }
}
