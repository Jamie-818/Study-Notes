package com.show.design.patterns.openclose;

/**
 * java课程折扣类 实现类
 *
 * @author xuanweiyao
 * @date 22:07 2019/7/21
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {

        super(id, name, price);
    }

    /**
     * 获取课程原价
     *
     * @author xuanweiyao
     * @date 22:10 2019/7/21
     */
    public Double getOriginPrce() {

        return super.getPrice();
    }

    /** 获取课程价格 */
    @Override
    public Double getPrice() {

        return super.getPrice() * 0.8;
    }
}
