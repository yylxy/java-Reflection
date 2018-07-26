package reflection.proxy.dynamic;

import reflection.proxy.dynamic.DynamicProxy.Subject;
import reflection.proxy.dynamic.DynamicProxy.Buyer2;
import reflection.proxy.dynamic.DynamicProxy.Buyer1;


public class Main {
    public static void main(String[] args) throws Exception {
        // 1. 创建调用处理器类对象
        DynamicProxy dynamicProxy = new DynamicProxy();

        // 2. 创建目标对象对象
       Buyer1 mBuyer1 = new DynamicProxy.Buyer1();

        // 3. 创建动态代理类 & 对象：通过调用处理器类对象newProxyInstance（）
        // 传入上述目标对象对象
        Subject Buyer1_DynamicProxy = (Subject) dynamicProxy.newProxyInstance(mBuyer1);

        // 4. 通过调用动态代理对象方法从而调用目标对象方法
        // 实际上是调用了invoke（），再通过invoke（）里的反射机制调用目标对象的方法
        Buyer1_DynamicProxy.buybuybuy();
        // 以上代购为小成代购Mac

        // 以下是代购为小何代购iPhone
        Buyer2 mBuyer2 = new DynamicProxy.Buyer2();
        Subject Buyer2_DynamicProxy = (Subject) dynamicProxy.newProxyInstance(mBuyer2);
        Buyer2_DynamicProxy.buybuybuy();
    }
}
