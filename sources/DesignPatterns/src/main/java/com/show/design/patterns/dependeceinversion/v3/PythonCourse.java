package com.show.design.patterns.dependeceinversion.v3;

public class PythonCourse implements ICourse {
  @Override
  public void studyCourse() {
    System.out.println("Show在学习Python课程");
  }
}
