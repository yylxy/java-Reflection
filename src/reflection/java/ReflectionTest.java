package reflection.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        //利用反射调用构造函数
        example2();

        //利用反射获取属性 & 赋值
        example();

        //通过 Class 对象分别获取Constructor类对象、Method类对象 & Field 类对象
        createClass();

        //判断Class对象
        judgeClass();

        //获取 目标类型的`Class`对象的方式主要有4种
        getTargetClass();


    }

    /**
     * 测试类定义
     */
    public static class Student2 {
        private String name;

        public Student2() {
            System.out.println("无参构造 ");
        }

        public Student2(String str) {
            System.out.println("有参构造 " + "****" + str);
        }
    }

    /**
     * 利用反射调用构造函数
     */
    private static void example2() throws Exception {
        //利用反射调用构造函数
        // 1. 获取Student类的Class对象
        Class studentClass = Student2.class;

        // 2.1 通过Class对象获取Constructor类对象，从而调用无参构造方法
        // 注：构造函数的调用实际上是在newInstance()，而不是在getConstructor()中调用
        Object mObj1 = studentClass.getConstructor().newInstance();

        // 2.2 通过Class对象获取Constructor类对象（传入参数类型），从而调用有参构造方法
        Object mObj2 = studentClass.getConstructor(String.class).newInstance("OK");
    }

    /**
     * 测试类定义
     */
    public static class Student {
        private String name;

        public Student() {
            System.out.println("创建了一个Student实例");
        }
    }

    /**
     * 利用反射获取属性 & 赋值
     */
    private static void example() throws Exception {
        //利用反射获取属性 & 赋值
        // 1. 获取Student类的Class对象
        Class<Student> studentClass = Student.class;

        // 2. 通过Class对象创建Student类的对象
        Constructor<?> constructor = studentClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object mStudent = studentClass.newInstance();

        // 3. 通过Class对象获取Student类的name属性
        Field f = studentClass.getDeclaredField("name");

        // 4. 设置私有访问权限
        f.setAccessible(true);

        // 5. 对新创建的Student对象设置name值
        f.set(mStudent, "我是java 反射");

        // 6. 获取新创建Student对象的的name属性 & 输出
        System.out.println(f.get(mStudent));
    }


    /**
     * 通过 Class 对象分别获取Constructor类对象、Method类对象 & Field 类对象
     */
    private static void createClass() throws NoSuchMethodException {
        String str = "string";

        Constructor constructor = str.getClass().getConstructor(str.getClass());
        System.out.println("constructor:" + constructor);
        str.getClass().getFields();

    }

    /**
     * 判断Class对象
     */
    private static void judgeClass() throws ClassNotFoundException {
        // 对于2个String类型对象，它们的Class对象相同
        Class c1 = "class".getClass();
        Class c2 = Class.forName("java.lang.String");
        // 用==运算符实现两个类对象地址的比较
        System.out.println(c1 == c2);
        // 输出结果：true
    }

    /**
     * 获取 目标类型的`Class`对象的方式主要有4种
     */
    private static void getTargetClass() throws ClassNotFoundException {
        // 获取 目标类型的`Class`对象的方式主要有4种
        /** 方式1：Object.getClass()
         * Object类中的getClass()返回一个Class类型的实例*/
        Boolean temp = true;
        Class type = temp.getClass();
        System.out.println(type);//结果：class java.lang.Boolean

        /** 方式2：T.class 语法,T = 任意Java类型
         * 注：Class对象表示的是一个类型，而这个类型未必一定是类
         *如，int不是类，但int.class是一个Class类型的对象*/
        Class<Boolean> temp2 = Boolean.class;
        System.out.println(temp2);//结果：class java.lang.Boolean
        Class<Integer> temp21 = int.class;
        System.out.println(temp21);//结果：int


        /** 方式3：static method Class.forName
         Class<?> classType = Class . forName ("java.lang.Boolean"); */
        Class temp3 = Class.forName("java.lang.Boolean");
        System.out.println(temp3);//结果：class java.lang.Boolean

        /** 方式4：TYPE语法
         * Class<?> classType = Boolean . TYPE*/
        Class<?> temp4 = Boolean.TYPE;
        System.out.println(temp4);//结果：boolean
    }
}
