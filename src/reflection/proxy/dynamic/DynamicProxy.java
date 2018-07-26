package reflection.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    // 声明代理对象
    // 作用：绑定关系，即关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke（）
    private Object ProxyObject;

    public Object newProxyInstance(Object ProxyObject) {
        this.ProxyObject = ProxyObject;
        return Proxy.newProxyInstance(ProxyObject.getClass().getClassLoader(),
                ProxyObject.getClass().getInterfaces(), this);
        // Proxy类 = 动态代理类的主类
        // Proxy.newProxyInstance（）作用：根据指定的类装载器、一组接口 & 调用处理器 生成动态代理类实例，并最终返回
        // 参数说明：
        // 参数1：指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        // 参数2：指定目标对象的实现接口
        // 即要给目标对象提供一组什么接口。若提供了一组接口给它，那么该代理对象就默认实现了该接口，这样就能调用这组接口中的方法
        // 参数3：指定InvocationHandler对象。即动态代理对象在调用方法时，会关联到哪个InvocationHandler对象

    }

    //  复写InvocationHandler接口的invoke（）
    //  动态代理对象调用目标对象的任何方法前，都会调用调用处理器类的invoke（）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
    // 参数说明：
    // 参数1：动态代理对象（即哪个动态代理对象调用了method（）
    // 参数2：目标对象被调用的方法
    // 参数3：指定被调用方法的参数
            throws Throwable {
        System.out.println("代购出门了");
        Object result = null;
        // 通过Java反射机制调用目标对象方法
        result = method.invoke(ProxyObject, args);
        return result;
    }

    public static interface Subject {
        // 定义目标对象的接口方法
        // 代购物品
        public void buybuybuy();

    }

    // 小成，真正的想买Mac的对象 = 目标对象 = 被代理的对象
    // 实现抽象目标对象的接口
    public static class Buyer1 implements Subject {

        @Override
        public void buybuybuy() {
            System.out.println("小成要买Mac");
        }

    }

    // 小何，真正的想买iPhone的对象 = 目标对象 = 被代理的对象
    // 实现抽象目标对象的接口
    public static class Buyer2 implements Subject {

        @Override
        public void buybuybuy() {
            System.out.println("小何要买iPhone");
        }

    }
}

