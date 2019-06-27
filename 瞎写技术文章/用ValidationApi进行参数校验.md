##### SpringBoot使用 ValidationApi 进行参数校验我们在开发的时候常常需要对参数进行校验，传统的做法是把每个参数拿出来然后进行判空操作，接口一旦多起来，冗余代码非常多。

##### 我们可以通过 ValidationApi 来解决这个问题

```xml
<!--添加依赖-->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>
```
##### 如果你的项目是 SpringBoot2 项目就不用添加依赖了，web组件已经内置了这个依赖了, Spring 官方也大量的使用了该Jar包。

| 注解名                                                | 适用的类型                                            | 含义                                                         |
| ----------------------------------------------------- | ----------------------------------------------------- | ------------------------------------------------------------ |
| @AssertFalse                                          | Boolean, boolean                                      | 用于boolean字段，该字段只能为true                            |
| @AssertFalse                                          | Boolean, boolean                                      | 用于boolean字段，该字段只能为false                           |
| @DecimalMax（value=x）                                | BigDecimal, BigInteger, String, byte,short, int, long | 验证注解的元素值小于等于@ DecimalMax指定的value值            |
| @DecimalMin（value=x）                                | BigDecimal, BigInteger, String, byte,short, int, long | 验证注解的元素值大于等于@ DecimalMin指定的value值            |
| @Digits(integer=整数位数, fraction=小数位数)          | BigDecimal, BigInteger, String, byte,short, int, long | 验证注解的元素值的整数位数和小数位数上限                     |
| @Email                                                | CharSequence                                          | 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式 |
| @Future(integer=整数位数, fraction=小数位数)          | java.util.Date, java.util.Calendar                    | 验证注解的元素值（日期类型）比当前时间晚                     |
| @FutureOrPresent(integer=整数位数, fraction=小数位数) | java.util.Date, java.util.Calendar                    | 验证注解的元素值（日期类型）比当前时间晚或者等于当前时间     |
| @Past                                                 | java.util.Date, java.util.Calendar                    | 验证注解的元素值（日期类型）比当前时间早                     |
| @PastOrPresent                                        | java.util.Date, java.util.Calendar                    | 验证注解的元素值（日期类型）比当前时间早或等于现在           |
| @Max（value=x）                                       | BigDecimal, BigInteger, byte, short,int, long         | 验证注解的元素值小于等于@Max指定的value值                    |
| @Mix（value=x）                                       | BigDecimal, BigInteger, byte, short,int, long         | 验证注解的元素值大于等于@Max指定的value值                    |
| @NotBlank                                             | CharSequence                                          | 验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格 |
| @NotEmpty                                             | CharSequence                                          | 验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0） |
| @NotNull                                              | Any type                                              | 验证注解的元素值不是null                                     |
| @Null                                                 | Any type                                              | 验证注解的元素值是null                                       |
| @Pattern(regex=正则表达式, flag=)                     | String                                                | 验证注解的元素值与指定的正则表达式匹配                       |
| @Size(min=最小值, max=最大值)                         | String, Collection, Map and arrays                    | 验证注解的元素值的在min和max（包含）指定区间之内，如字符长度、集合大小 |



##### 我们只需要在对象上加上注解

```java
@Data
public class ValidationParam {
  @NotBlank(message = "用户名不能为空")
  String username;

  @NotBlank(message = "手机号码不能为空")
  String phone;

  @NotBlank(message = "身份证不能为空")
  String idCard;
}
```

#####  接口在接收参数的时候，加上 @Valid 注解，指名这个参数需要进行校验

```java
@RestController
@RequestMapping("/ValidationResultTest")
public class ValidationController {
  @PostMapping()
  public String ValidationResultTest(@Valid @RequestBody ValidationParam validationParam) {
    System.out.println(validationParam);
    return "success";
  }
}
```

​                                 

![](C:\Users\show\AppData\Roaming\Typora\typora-user-images\1557993466087.png)

##### 如果我们只校验不处理的话，调用方会接收到一个400个报错，我们也可以自定义处理

```java
@RestController
@RequestMapping("/ValidationResultTest")
public class ValidationController {
  @PostMapping()
  public String ValidationResultTest(
      @Valid @RequestBody ValidationParam validationParam, BindingResult results) {
    if (results.hasErrors()) {
      return "请求参数异常,错误信息为:" + results.getFieldError().getDefaultMessage();
    }
    System.out.println(validationParam);
    return "success";
  }
}
```

##### 这时我们的返回值为

![1557993828749](C:\Users\show\AppData\Roaming\Typora\typora-user-images\1557993828749.png)

> ##### 注意，BindingResult 对象 必须在需要校验的对象后面。



### 手机号码校验

##### ValidationApi 不提供手机号码格式校验 (毕竟每个国家的手机号码格式不一样) ，我们可以自己定义处理

```java
@ConstraintComposition(CompositionType.OR)
@Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}")
@NotBlank
@Documented
@Constraint(validatedBy = {})
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface Phone {
  String message() default "手机号校验错误";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
```

```java
@Data
public class ValidationParam {
  @NotBlank(message = "用户名不能为空")
  String username;

  @Phone
  String phone;

  @NotBlank(message = "身份证不能为空")
  String idCard;
}
```

##### 这样我们就可以校验手机号码了,其他同理

##### 参考文章 [Spring MVC 之输入验证（六）](https://www.cnblogs.com/hellokitty1/p/5167839.html)                


​                        
​                                                               

​                                                                           

