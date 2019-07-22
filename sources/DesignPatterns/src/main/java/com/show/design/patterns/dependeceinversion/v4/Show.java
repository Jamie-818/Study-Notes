package com.show.design.patterns.dependeceinversion.v4;

/**
 * 人
 *
 * @author xuanweiyao
 * @date 21:11 2019/7/22
 */
public class Show {
  private ICourse iCourse;

  /**
   * set方法 通过set方式注入实现类
   *
   * @author xuanweiyao
   * @date 21:59 2019/7/22
   * @param iCourse
   * @return void
   */
  public void setiCourse(ICourse iCourse) {

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
