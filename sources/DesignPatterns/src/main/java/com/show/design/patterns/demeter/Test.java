package com.show.design.patterns.demeter;

public class Test {
  public static void main(String[] args) {
    Boss b = new Boss();
    TeamLeader teamLeader = new TeamLeader();
    b.commandCheckNumber(teamLeader);
  }
}
