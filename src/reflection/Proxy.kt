package reflection


/**
 * 代理模式
 */
fun main(args: Array<String>) {
    // 1. 动态生成产品类实例
    val concreteProduct = Factory.getInstance(ProductA::class.java)
    // 2. 调用该产品类对象的方法，从而生产产品
    concreteProduct!!.show()

    //生产B产品
    val productB = Factory.getInstance(ProductB::class.java)
    productB!!.show()
    //因为返回的是指定类型的不用判断类型，也不强转类型
    productB.print()

}

/**
 * 产品抽象
 */
abstract class Product {
    abstract fun show()
}

/**
 * 产品A
 */
class ProductA : Product() {
    override fun show() {
        println("生产出了产品A")
    }

}

/**
 * 产品B
 */
class ProductB : Product() {
    override fun show() {
        println("生产出了产品B")
    }

    fun print() {
        println("产品B会打印")
    }
}

/**
 * 工厂类.利用反射创建产品
 */
object Factory {
    // 定义方法：通过反射动态创建产品类实例
    internal fun <T> getInstance(cla: Class<T>): T? {
        var type: T? = null
        try {
            // 1. 根据传入的class 得到name ,获取class
            val aClass = Class.forName(cla.name)
            // 2. 通过Class对象动态创建该产品类的实例
            type = aClass.newInstance() as T
        } catch (e: Exception) {
            e.printStackTrace()
        }
        // 3. 返回传入的类型
        return type
    }
}

