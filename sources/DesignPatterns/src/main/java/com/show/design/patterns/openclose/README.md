![](.开闭原则_images/7152026e.png)
> 需要实现功能时，不改变原代码，通过接口继承的方式实现。
功能：设计一个课程类，实现原价及折扣价格。
- 定义一个课程的接口(ICourse)
- 定义一个类(JavaCourse)实现该接口(ICourse)
- 特殊功能(例如打折)实现时，定义一个类(JavaDiscountCourse)继承实现类(JavaCourse)