package com.show.design.patterns.dependeceinversion.v2;

public class GoCourse implements ICourse {
  @Override
  public void studyCourse() {
    System.out.println("Show在学习Go课程");
  }
}
