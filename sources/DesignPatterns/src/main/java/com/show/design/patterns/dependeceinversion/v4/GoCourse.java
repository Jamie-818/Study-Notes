package com.show.design.patterns.dependeceinversion.v4;

public class GoCourse implements ICourse {
  @Override
  public void studyCourse() {
    System.out.println("Show在学习Go课程");
  }
}
