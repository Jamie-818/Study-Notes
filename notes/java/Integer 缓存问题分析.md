# Integer 缓存问题分析

我们先看下面的示例代码，并思考该段代码的输出结果：

```java
public class IntTest {
	public static void main(String[] args) {
	    Integer a = 100, b = 100, c = 150, d = 150;
	    System.out.println(a == b);
	    System.out.println(c == d);
	}
}
```

通过运行代码可以得到答案，程序输出的结果分别为： `true` , `false`。

**那么为什么答案是这样？**

很多人刷过面试题可能会颇有自信地回答：**因为缓存了 -128 到 127 之间的数值**，就没有然后了。
这里可以引申出三个问题
- 1、 那么为什么会缓存这一段区间的数值？
- 2、 缓存的区间可以修改吗？
- 3、 其它的包装类型有没有类似缓存？

我们可以通过下面的方法，得到答案！

## 1 源码分析法

首先我们可以通过源码对该问题进行分析。

我们知道，`Integer var = ?` 形式声明变量，会通过 `java.lang.Integer#valueOf(int)` 来构造 `Integer` 对象。

如果不知道的话可以`Integer.java`源码页`829`行打断点(JDK8)

- 可以通过IDEA点击两下`shift`,在`tab`栏选择`classes`,输入`Integer`快速进入到`Integer.java`页面(记得配好JDK)。jdk8版本的`valueOf(int)`函数在`829`行。

我们先看该函数源码：

```java
/**
 * Returns an {@code Integer} instance representing the specified
 * {@code int} value.  If a new {@code Integer} instance is not
 * required, this method should generally be used in preference to
 * the constructor {@link #Integer(int)}, as this method is likely
 * to yield significantly better space and time performance by
 * caching frequently requested values.
 *
 * This method will always cache values in the range -128 to 127,
 * inclusive, and may cache other values outside of this range.
 *
 * @param  i an {@code int} value.
 * @return an {@code Integer} instance representing {@code i}.
 * @since  1.5
 */
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
```

通过源码可以看出，如果用 `Ineger.valueOf(int)` 来创建整数对象，参数大于等于整数缓存的最小值（ `IntegerCache.low` ）并小于等于整数缓存的最大值（ `IntegerCache.high`）, 会直接从缓存数组 (`java.lang.Integer.IntegerCache#cache`) 中提取整数对象；否则会 `new` 一个整数对象。

从上述注释中我们可以看出，最小值是 `-128`, 最大值是 `127`。

**这时候通过注释也可以得到第一个问题的答案**
- **如果不要求必须新建一个整型对象，缓存最常用的值（提前构造缓存范围内的整型对象），会更省空间，速度也更快。**

这给我们一个非常重要的启发：

> 如果想减少内存占用，提高程序运行的效率，可以将常用的对象提前缓存起来，需要时直接从缓存中提取。

那么我们再研究下一个问题： **`Integer` 缓存的区间可以修改吗？**

通过上述源码和注释我们还无法回答这个问题，接下来，我们继续看 `java.lang.Integer.IntegerCache` 的源码(在`780`行)

```java
/**
 * Cache to support the object identity semantics of autoboxing for values between
 * -128 and 127 (inclusive) as required by JLS.
 *
 * The cache is initialized on first usage.  The size of the cache
 * may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} option.
 * During VM initialization, java.lang.Integer.IntegerCache.high property
 * may be set and saved in the private system properties in the
 * sun.misc.VM class.
 */

private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static final Integer cache[];

    static {
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue =
            sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
            } catch( NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;

        cache = new Integer[(high - low) + 1];
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);

        // range [-128, 127] must be interned (JLS7 5.1.7)
        assert IntegerCache.high >= 127;
    }

    private IntegerCache() {}
}
```

通过 `IntegerCache` 代码和注释我们可以看到，最小值是固定值 -128， 最大值并不是固定值，缓存的最大值是可以通过虚拟机参数 `-XX:AutoBoxCacheMax=}` 或 `-Djava.lang.Integer.IntegerCache.high=` 来设置的，未指定则为 127。

因此可以通过修改这两个参数其中之一，让缓存的最大值大于等于 150。

如果作出这种修改，示例的输出结果便会是： `true`,`true`。

**这时候通过注释和源码得到了第二个问题的答案**
 - **最小值是固定值 -128， 最大值并不是固定值，缓存的最大值是可以通过虚拟机参数 `-XX:AutoBoxCacheMax=}` 或 `-Djava.lang.Integer.IntegerCache.high=` 来设置的，未指定则为 127。**

这段注释也解答了为什么要缓存这个范围的数据：
**而且通过注释`Cache to support the object identity semantics of autoboxing for values between -128 and 127 (inclusive) as required by JLS.`也得到了第三个问题的答案**

> **是为了自动装箱时可以复用这些对象** ，这是JLS的要求。

我们可以参考 JLS 的 [Boxing Conversion 部分](https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1.7)的相关描述。

> If the value`p`being boxed is an integer literal of type `int`between `-128`and `127`inclusive ([§3.10.1](https://docs.oracle.com/javase/specs/jls/se8/html/jls-3.html#jls-3.10.1)), or the boolean literal `true`or`false`([§3.10.3](https://docs.oracle.com/javase/specs/jls/se8/html/jls-3.html#jls-3.10.3)), or a character literal between `'\u0000'`and `'\u007f'`inclusive ([§3.10.4](https://docs.oracle.com/javase/specs/jls/se8/html/jls-3.html#jls-3.10.4)), then let `a`and `b`be the results of any two boxing conversions of `p`. It is always the case that `a`==`b`.
>
> 在 -128 到 127 （含）之间的 int 类型的值，或者 boolean 类型的 true 或 false， 以及范围在’\u0000’和’\u007f’ （含）之间的 char 类型的数值 p， 自动包装成 a 和 b 两个对象时， 可以使用 a == b 判断 a 和 b 的值是否相等。



## 2 反汇编法

那么究竟 `Integer var = ?` 形式声明变量，是不是通过 `java.lang.Integer#valueOf(int)` 来构造 `Integer` 对象呢？ 总不能都是猜测 N 个可能的函数，然后断点调试吧？

这类问题有个杀手锏，可以通过对编译后的 class 文件进行反汇编来查看。

首先编译源代码：`javac IntTest.java`

然后需要对代码进行反汇编，执行：`javap -c IntTest`

> 如果想了解 `javap` 的用法，直接输入 `javap -help` 查看用法提示（很多命令行工具都支持 `-help` 或 `--help` 给出用法提示）。
```bash
PS C:\Windows\system32> javap
用法: javap <options> <classes>
其中, 可能的选项包括:
  -help  --help  -?        输出此用法消息
  -version                 版本信息
  -v  -verbose             输出附加信息
  -l                       输出行号和本地变量表
  -public                  仅显示公共类和成员
  -protected               显示受保护的/公共类和成员
  -package                 显示程序包/受保护的/公共类
                           和成员 (默认)
  -p  -private             显示所有类和成员
  -c                       对代码进行反汇编
  -s                       输出内部类型签名
  -sysinfo                 显示正在处理的类的
                           系统信息 (路径, 大小, 日期, MD5 散列)
  -constants               显示最终常量
  -classpath <path>        指定查找用户类文件的位置
  -cp <path>               指定查找用户类文件的位置
  -bootclasspath <path>    覆盖引导类文件的位置
```

反编译后，我们得到以下代码：

```java
PS E:\show-product\work-product\demo\target\classes\com\example\demo> javap -c .\IntTest.class
Compiled from "IntTest.java"
public class com.example.demo.IntTest {
  public com.example.demo.IntTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: bipush        100
       2: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       5: astore_1
       6: bipush        100
       8: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      11: astore_2
      12: sipush        150
      15: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      18: astore_3
      19: sipush        150
      22: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      25: astore        4
      27: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
      30: aload_1
      31: aload_2
      32: if_acmpne     39
      35: iconst_1
      36: goto          40
      39: iconst_0
      40: invokevirtual #4                  // Method java/io/PrintStream.println:(Z)V
      43: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
      46: aload_3
      47: aload         4
      49: if_acmpne     56
      52: iconst_1
      53: goto          57
      56: iconst_0
      57: invokevirtual #4                  // Method java/io/PrintStream.println:(Z)V
      60: return
}
```

可以明确得 "看到" 这四个 ``Integer var = ? `形式声明的变量的确是通过` java.lang.Integer#valueOf(int) `来构造` Integer` 对象的。

**接下来对汇编后的代码进行详细分析，如果看不懂可略过**：

根据[《Java Virtual Machine Specification : Java SE 8 Edition》](https://docs.oracle.com/javase/specs/jvms/se8/html/index.html)[3](http://www.imooc.com/read/55/article/1139#fn3)，后缩写为 JVMS , 第 6 章 [虚拟机指令集](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html)的相关描述以及《深入理解 Java 虚拟机》[4](http://www.imooc.com/read/55/article/1139#fn4) 414-149 页的 附录 B “虚拟机字节码指令表”。 我们对上述指令进行解读：

偏移为 0 的指令为：`bipush 100` ，其含义是将单字节整型常量 100 推入操作数栈的栈顶；

偏移为 2 的指令为：`invokestatic #2 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;` 表示调用一个 `static` 函数，即 `java.lang.Integer#valueOf(int)`；

偏移为 5 的指令为：`astore_1` ，其含义是从操作数栈中弹出对象引用，然后将其存到第 1 个局部变量 Slot 中；

偏移 6 到 25 的指令和上面类似；

偏移为 30 的指令为 `aload_1` ，其含义是从第 1 个局部变量 Slot 取出对象引用（即 a），并将其压入栈；

偏移为 31 的指令为 `aload_2` ，其含义是从第 2 个局部变量 Slot 取出对象引用（即 b），并将其压入栈；

偏移为 32 的指令为 `if_acmpn`，该指令为条件跳转指令，`if_` 后以 a 开头表示对象的引用比较。

由于该指令有以下特性：

> - `if_acmpeq` 比较栈两个引用类型数值，相等则跳转
> - `if_acmpne` 比较栈两个引用类型数值，不相等则跳转

由于 `Integer` 的缓存问题，所以 a 和 b 引用指向同一个地址，因此此条件不成立（成立则跳转到偏移为 39 的指令处），执行偏移为 35 的指令。

偏移为 35 的指令: `iconst_1`，其含义为将常量 1 压栈（ Java 虚拟机中 boolean 类型的运算类型为 int ，其中 true 用 1 表示，详见 [2.11.1 数据类型和 Java 虚拟机](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html#jvms-2.11.1)。

然后执行偏移为 36 的 `goto` 指令，跳转到偏移为 40 的指令。

偏移为 40 的指令：`invokevirtual #4 // Method java/io/PrintStream.println:(Z)V`。

可知参数描述符为 `Z` ，返回值描述符为 `V`。

根据 [4.3.2 字段描述符](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3.2) ，可知 `FieldType` 的字符为 `Z` 表示 `boolean` 类型， 值为 `true` 或 `false`。
根据 [4.3.3 字段描述符](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3.3) ，可知返回值为 `void`。

因此可以知，最终调用了 `java.io.PrintStream#println(boolean)` 函数打印栈顶常量即 `true`。

然后比较执行偏移 43 到 57 之间的指令，比较 c 和 d， 打印 `false` 。

执行偏移为 60 的指令，即 `retrun` ，程序结束。

如果大家不喜欢命令行的方式进行 Java 的反汇编，这里推荐一个IDEA简单易用的可视化插件：[jclasslib](https://plugins.jetbrains.com/plugin/9248-jclasslib-bytecode-viewer/) ，大家可以自行了解学习。
![IntTest](http://blog.xuanweiyao.com/upload/2020/1/IntTest-de00d1bd81484afb8d5c34fc8d84c822.png)

**第三个问题，在下一篇文章 `Long 缓存问题分析` 中就能得到答案**