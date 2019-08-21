# synchronized深度解析
## Synchronized简介
### Synchronized作用
- 官方： 同步方式支持一种简单的策略来防止线程干扰和内存一致性错误：如果一个对象对多个线程可见，则对对象变量的所有读取或写入都是通过同步方法完成的。
- 个人： 能够保证在同一个时刻最多只有一个线程执行该段代码，以达到保证并发安全的效果。    
### Synchronized的地位
- Synchronized是Java的关键字，被Java语言原生支持
- 是最基本的互斥同步手段
- 是并发编程中的元老级角色，是并发编程的必学内容
### 不用并发手段的后果预警
- 代码实战：两个线程同时a++，最后结果会比预计的少
```java
/**
 * 消息的请求
 * @author xuanweiyao
 * @date 17:26 2019/8/20
 */
public class DisappearRequest1 implements Runnable {
  static DisappearRequest1 instance = new DisappearRequest1();
  static int i = 0;
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(instance);
    Thread t2 = new Thread(instance);
    t1.start();
    t2.start();
    t1.join(); 
    t2.join();
    System.out.println(i); //159965
  }
  @Override
  public void run() {
    for (int i1 = 0; i1 < 100000; i1++) {
      i++;
    }
  }
}
```
- 原因
   > count++，它看上去只是一个操作，实际上包含了三个动作
   - 1.读取count
   - 2.将count加1
   - 3.将count的值写入到内存中
- 所以会出现t1线程并未把count加1后的值写入到内存中后t2就读取count值，导致这次加1操作无效。

## Synchronized的两种用法（对象锁和类锁）
## 多线程访问同步方法的7种具体情况
## Synchronized的性质
## 深入原理
## Synchronized的缺陷
## 常见面试题