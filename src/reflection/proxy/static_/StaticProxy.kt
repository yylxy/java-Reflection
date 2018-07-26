package reflection.proxy.static_

fun main(args: Array<String>) {
    //通过代理进行使用
    val subject = ProxySubject()
    subject.buyComputer()
}

/**
 *抽象对象接口,对外提供的能力
 */
interface ISubject {
    //购买电脑
    fun buyComputer()
}

/**
 * 真实实业务现对象
 */
class RealSubject : ISubject {
    override fun buyComputer() {
        println("我去买电脑")
    }
}

/**
 * 代理的实现对象
 */
class ProxySubject : ISubject {
    //创建真实的实现
    private val realSubject = RealSubject()

    override fun buyComputer() {
        //调用真实的实现对象
        realSubject.buyComputer()
        //调用额外操作
        wrapComputer()
    }

    //代理提供额外的操作
    private fun wrapComputer() {
        println("代理包装电脑")
    }
}
