package com.show.design.patterns.singleresponslibility;
/**
 * 单一职责方法
 *
 * @author xuanweiyao
 * @date 22:07 2019/7/25
 */
public class Method {
  private String userName;
  private String address;

  private void updateUserName(String userName) {
    this.userName = userName;
  }

  private void updateAddress(String address) {
    this.address = address;
  }
}
