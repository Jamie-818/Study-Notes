package com.show.design.patterns.singleresponslibility;
/**
 * 课程接口
 *
 * @author xuanweiyao
 * @date 22:00 2019/7/25
 */
public interface ICourse {
  String getCourseName();

  byte[] getCourseVideo();

  void studyCourse();

  void refundCourse();
}
