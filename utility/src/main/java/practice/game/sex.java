package practice.game;

/**
 * Created by 魔诃不思议 on 2017/7/30.
 * Real-world objects contain state and behavior.
 * 真实世界的对象包含【状态】和【行为】
 * A software object's state is stored in fields.
 * 一个软件对象的状态储存在【字段】中
 * A software object's behavior is exposed through methods.
 * 一个软件对象的行为通过方法展露
 * Hiding internal data from the outside world, and accessing it only through publicly exposed methods is known as data encapsulation.
 * 对外界隐藏内部的数据，并且只能通过公开展露的方法访问。这种对数据的处理方式称做数据的封装
 * A blueprint for a software object is called a class.
 * 一个软件对象的蓝图称做类
 * Common behavior can be defined in a superclass and inherited into a subclass using the extends keyword.
 * 一般行为可以在超类中定义并使用extends关键字继承到一个子类
 * A collection of methods with no implementation is called an interface.
 * 没有实现的方法们的一个集合被称为接口
 * A namespace that organizes classes and interfaces by functionality is called a package.
 * 按功能组织类和接口的命名空间被称为包
 * The term API stands for Application Programming Interface.
 * 术语API是指 应用程序编程接口
 */
enum sex {
    man, woman, unknown;
}
