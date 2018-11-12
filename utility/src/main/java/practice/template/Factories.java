package practice.template;
/**
 * 工厂模式--《设计优化》
 * 效果：将类的接口与实现彻底分开
 * 作用：有利于增加抽象性，灵活性
 * 副作用：徒增复杂性，使设计优化变得草率
 * 使用原则：如非必要，勿增实体（若没有真正的需求 ，不要增加新的接口，类型）
 * */

interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

/**
 * one implements of mypackage.Template.implementations1
 * 用于实现接口
 */
class implementations1 implements Service {
    public implementations1() {
    }

    @Override
    public void method1() {
        System.out.println(getClass().getName() + " " + "method1");
    }

    @Override
    public void method2() {
        System.out.println(getClass().getName() + " " + "method2");
    }
}

/**
 * one group of module
 * using to 组合各种类型
 * @author 魔诃不思议
 */
class implementation1Factory implements ServiceFactory {
    /**
     * @return 返回接口(向上转型)
    * */
    @Override
    public Service getService() {
        return new implementations1();
    }
}

class implementations2 implements Service {
    public implementations2() {
    }

    @Override
    public void method1() {
        System.out.println(getClass().getName() + " " + "method1");
    }

    @Override
    public void method2() {
        System.out.println(getClass().getName() + " " + "method2");
    }
}

class implementation2Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new implementations2();
    }
}

public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) throws Exception {
        serviceConsumer(new implementation1Factory());
        serviceConsumer(new implementation2Factory());
    }
}
