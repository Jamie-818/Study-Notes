package com.show.design.patterns.dependeceinversion.v4;

public class FECourse implements ICourse {
  @Override
  public void studyCourse() {
    System.out.println("Show在学习FE课程");
  }
}
