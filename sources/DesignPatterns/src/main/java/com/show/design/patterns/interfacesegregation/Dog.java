package com.show.design.patterns.interfacesegregation;
/**
 * 狗
 *
 * @author xuanweiyao
 * @date 22:16 2019/7/25
 */
public class Dog implements IEatAnimalAction, ISwimAnimalAction {
  @Override
  public void eat() {}

  @Override
  public void swin() {}
}
