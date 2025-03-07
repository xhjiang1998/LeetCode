package xhjiang.scene;

import org.junit.Test;

/**
 * @description: 主要是关于字符串的基础函数测试
 * @author: xhjiang
 * @date: 2025/2/24 16:04
 *
 * hashcode主要是用来计算hashset和hashmap等存储的结构中散列表的位置
 * equals主要是用来判断两个对象地址是否相等，等价于'=='方法，不覆写比较的是内存地址，覆写则比较的是对象的内容
 * ==方法比较的是两个对象的内存地址
 *
 * 常用的数值类型的话，通常用==来比较，字符串类型通常用equals来比较
 */
public class StringTest {

    /**
     * 测试两个字符串的哈希码和相等性
     * 此方法旨在演示字符串哈希码的比较以及字符串内容和引用的比较
     * 通过打印字符串的哈希码和它们是否相等来帮助理解字符串在Java中的行为
     *
     * @param a 第一个字符串，用于比较哈希码和内容
     * @param b 第二个字符串，用于比较哈希码和内容
     */
    public static void stringHashTest(String a, String b) {
        // 打印第一个字符串的哈希码
        System.out.println(a + "的hashcode：" + a.hashCode());
        // 打印第二个字符串的哈希码
        System.out.println(b + "的hashcode:" + b.hashCode());
        // 检查并打印两个字符串内容是否相等
        System.out.println(a + "是否equals" + b + ":" + a.equals(b));
        // 检查并打印两个字符串引用是否相同注意，这里比较的是引用，而不是内容
        System.out.println("a==b:" + a == b);
    }

    /**
     * String s1 = "" 和 new String() 都可以创建一个空字符串，但它们的实现方式和内存分配机制不同。
     * String s1 = "" 会直接引用字符串常量池中的空字符串，而 new String() 则会在堆内存中创建一个新的空字符串对象。
     *
     * @param args
     */
    public static void main(String[] args) {
        String a = "1";
        String b = "2";
        String c = a;// 相同引用的hashcode和equals是一样的
        String d = "1";//相同字符串的hashcode和equals是一样的，因为该字符串是来自于方法区的常量池
        stringHashTest(a, b);
        stringHashTest(a, c);
        stringHashTest(a, d);

        String a1 = new String("1");
        String b1 = new String("1");
        // 字符串改写了equals方法，使之为比较内容，而不是比较内存地址，所以此处equals为true
        //但是此处的==为false，说明两个对象在堆内存中不是同一个内存地址
        stringHashTest(a1, b1);


    }

    public static void testEquals(Object a, Object b) {
        System.out.println("a.equals(b):" + a.equals(b));
        System.out.println("a==b:" + a == b);
    }

    public static void testDouble(String a, String b) {
        if (a == b) {
            System.out.println("a==b");
        } else {
            System.out.println("a!=b");
        }
    }

    @Test
    public void test01() {
        testEquals("1", "1"); // 字符串的话equals是true，但是==是false，说明==判断的是：是否是同一个内存地址
        testEquals(1, 1);// 数字的话第一个true，第二个==为false。说明
        if (1 == 1) {
            System.out.println("1==1");// 基本数据类型，比较的是值
        }
    }

    @Test
    public void test02() {
        String a = new String("a");
        String b = new String("a");
        testDouble(a, b);// a!=b ，表明这两个不是同一个内存地址

        String c = a;
        testDouble(a, c);// a==c,表明这两个是同一个内存地址
    }


}
