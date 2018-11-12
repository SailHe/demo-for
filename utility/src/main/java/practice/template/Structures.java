package practice.template;

import practice.util.MyString;

import java.util.ArrayList;

/**
 *              《数据结构》
 *             保存对象的引用
 * 容器--集合类--Collection:指代该类的一个特殊子集
 *           base type:  {List,Set,Queue,Map}
 *           公共特性：自适应尺寸
 *           {
 *               ArrayList类：自适应尺寸数组{
 *                   add()
 *                   get(索引)
 *                   size()：已添加的元素数目(防止索引越界)
 *               }
 *           }
 * 数组：保存一组有固定尺寸的基本数据类型
 * */

class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {
    int id;
}

public class Structures {
    /**
     * Descriptions: 抑制警告信息:不受检查的异常<p>
     *
     * @author SailHe
     * @date 2018/11/11 19:01
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList myStringList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            myStringList.add(new MyString());
            ((MyString) myStringList.get(i)).value = new char[]{1321};
        }
        myStringList.add(new Apple());
        myStringList.add(new Orange());
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }
}
