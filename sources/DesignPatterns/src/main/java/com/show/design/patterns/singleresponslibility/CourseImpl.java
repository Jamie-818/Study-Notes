package com.show.design.patterns.singleresponslibility;

public class CourseImpl implements ICourseContent, ICourseManager {
  @Override
  public String getCourseName() {

    return null;
  }

  @Override
  public byte[] getCourseVideo() {

    return new byte[0];
  }

  @Override
  public void studyCourse() {}

  @Override
  public void refundCourse() {}
}
