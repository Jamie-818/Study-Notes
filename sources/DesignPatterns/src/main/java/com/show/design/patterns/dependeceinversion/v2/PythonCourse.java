package com.show.design.patterns.dependeceinversion.v2;

public class PythonCourse implements ICourse {
  @Override
  public void studyCourse() {
    System.out.println("Show在学习Python课程");
  }
}
