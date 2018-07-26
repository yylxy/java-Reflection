package javaR

fun main(args: Array<String>) {
    // 获取 目标类型的`Class`对象的方式主要有4种
    /** 方式1：Object.getClass()
     * Object类中的getClass()返回一个Class类型的实例*/
    val temp = true
    val type = temp.javaClass
    println("$type")//结果：boolean

    /** 方式2：T.class 语法,T = 任意Java类型
     * 注：Class对象表示的是一个类型，而这个类型未必一定是类
     *如，int不是类，但int.class是一个Class类型的对象*/
    val temp2 = Boolean::class.java
    println("$temp2")//结果：boolean
    val temp21 = Int::class.javaPrimitiveType
    println("$temp21")//结果：int

    /** 方式3：static method Class.forName
    Class<?> classType = Class . forName ("java.lang.Boolean"); */
    val temp3 = Class.forName("java.lang.Boolean")
    println("$temp3")//结果：class java.lang.Boolean

    /** 方式4：TYPE语法
     * lass<?> classType = Boolean . TYPE*/
    val temp4 = java.lang.Boolean.TYPE
    println("$temp4")//结果：boolean

}
