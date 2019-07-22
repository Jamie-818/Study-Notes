package com.show.design.patterns.dependeceinversion.v3;

public class GoCourse implements ICourse {
  @Override
  public void studyCourse() {
    System.out.println("Show在学习Go课程");
  }
}
