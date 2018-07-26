package reflection.java;

import java.lang.reflect.Method;

public class ReflectionTest2 {
    public static void main(String[] args) throws Exception {
        //利用反射调用方法
        example2();
    }

    /**
     * 测试类定义
     */
    public static class Student {
        public Student() {
            System.out.println("创建了一个Student实例");
        }

        // 无参数方法
        public void setName1() {
            System.out.println("调用了无参方法：setName1（）");
        }

        // 有参数方法
        public void setName2(String str) {
            System.out.println("调用了有参方法setName2（String str）:" + str);
        }
    }

    /**
     * 利用反射调用方法
     */
    private static void example2() throws Exception {
        //利用反射调用方法
        // 1. 获取Student类的Class对象
        Class studentClass = Student.class;

        // 2. 通过Class对象创建Student类的对象
        Object mStudent = studentClass.newInstance();

        // 3.1 通过Class对象获取方法setName1（）的Method对象:需传入方法名
        // 因为该方法 = 无参，所以不需要传入参数
        Method msetName1 = studentClass.getMethod("setName1");

        // 通过Method对象调用setName1（）：需传入创建的实例
        msetName1.invoke(mStudent);

        // 3.2 通过Class对象获取方法setName2（）的Method对象:需传入方法名 & 参数类型
        Method msetName2 = studentClass.getMethod("setName2", String.class);

        // 通过Method对象调用setName2（）：需传入创建的实例 & 参数值
        msetName2.invoke(mStudent, "Carson_Ho");
    }


}
