package reflection.factory;

/**
 * 代理模式
 */
public class FactoryTest {
    public static void main(String[] args) {
        // 1. 动态生成产品类实例
        Product concreteProduct = Factory.getInstance(ProductA.class);
        // 2. 调用该产品类对象的方法，从而生产产品
        concreteProduct.show();
    }

    /**
     * 产品抽象
     */
    abstract static class Product {
        public abstract void show();
    }

    /**
     * 产品A
     */
    public static class ProductA extends Product {
        @Override
        public void show() {
            System.out.println("生产出了产品A");
        }
    }

    /**
     * 产品B
     */
    public static class ProductB extends Product {

        @Override
        public void show() {
            System.out.println("生产出了产品B");
        }
    }

    /**
     * 工厂类.利用反射调用方法
     */
    @SuppressWarnings("unchecked")
    public static class Factory {
        // 定义方法：通过反射动态创建产品类实例
        static <T> T getInstance(Class<T> cla) {
            T type = null;
            try {
                // 1. 根据传入的class 得到name ,获取class
                Class aClass = Class.forName(cla.getName());
                // 2. 通过Class对象动态创建该产品类的实例
                type = (T) aClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 3. 返回传入的类型
            return type;
        }
    }
}
