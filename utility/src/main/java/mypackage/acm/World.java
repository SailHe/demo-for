package mypackage.acm;

interface Say {
    Blessing say(String word);
}

class Year implements Say {
    String year;

    public Year(String year) {
        this.year = year;
    }

    public Blessing say(String word) {
        System.out.printf(word);
        return new Blessing(year);
    }
}

class Blessing {
    String blessing;

    public Blessing(String blessing) {
        this.blessing = blessing;
    }

    void realize() {
        System.out.println(blessing);
    }
}

interface Shape {
    void draw();
}

class Point implements Shape {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("点类Draw " + x + " " + y);
    }
}

class Line implements Shape {
    Point origin;
    Integer length;

    public Line(Point origin, Integer length) {
        this.origin = origin;
        this.length = length;
    }

    public void draw() {
        System.out.println("线类Draw");
    }
}

class Circle implements Shape {
    Point center;
    Integer radius;

    public Circle(Point center, Integer radius) {
        this.center = center;
        this.radius = radius;
    }

    public void draw() {
        System.out.println("圆类Draw");
    }
}

/*线程测试*/
class Hello implements Runnable {
    private int i = 0;
    private boolean timeToQuit = false;

    public void run() {
        while (!timeToQuit) {
            System.out.println(Thread.currentThread().getName() +"优先级:"+ Thread.currentThread().getPriority() + " Hello" + i);
            try {
                if (i % 2 == 0) {
                    System.out.println("休息 timeToQuit="+timeToQuit);
                    Thread.sleep(2);
                    System.out.println("休息结束");
                }
                if (i > 10) {
                    stopRunning();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ++i;
        }
    }

    synchronized public void stopRunning() {
        this.timeToQuit = true;
    }
}

class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    //标识符id可以用来区分任务的多个实例，它是final的，因为它一旦被初始化之后就不希望被修改。
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"("+
                (countDown > 0 ? countDown : "LiftOff") + "), ";
    }
    /*
    * 任务的run（）方法通常总会有某种形式的循环，使得任务一直运行下去直到不再需要，所以
    * 要设定跳出循环的条件（有一种选择是直接从run（）返回）。通常， ·run（）被写成无限循环的形式，
    * 这就意味着，除非有某个条件使得run（）终止，否则它将永远运持下去
    * */
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            //线程调度器
            /*
            * 它在声明：“我已经执行完生命周期中最
            * 重要的部分了，此刻正是切换给其他任务执行一段时间的大好时机。”
            * 这完全是选择性的，但是这里使用它是因为它会在这些示例中产生更加有趣的输出：你更有可能会看到任务换进换出的证据。
            * */
            Thread.yield();
        }
    }
}

public class World {
    public static void main(String[] args) throws Exception {
        /*第一次*//*
        Say happy = new Year("2018");
        Blessing blessing = happy.say(" Hello World");
        blessing.realize();

        *//*第二次*//*
        Point p = new Point(1,1);
        p.draw();
        Shape line = new Line(p, 10);
        line.draw();
        Shape circle =  new Circle(p, 101);
        circle.draw();*/

        /*Thread */

        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");


        Hello h = new Hello();
        Thread t1 = new Thread(h, "t1");
        Thread t2 = new Thread(h, "t2");
        int i = 0;
        /*
        * start()方法的调用后并不是立即执行多线程代码，而是使得该线程变为可运行态（Runnable），什么时候运行是由操作系统决定的。
        * 从程序运行的结果可以发现，多线程程序是乱序执行。因此，只有乱序执行的代码才有必要设计为多线程。
        * Thread.sleep()方法调用目的是不让当前线程独自霸占该进程所获取的CPU资源，以留出一定时间给其他线程执行的机会。
        * 实际上所有的多线程代码执行顺序都是不确定的，每次执行的结果都是随机的。
        * */
        //t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getName() +"优先级:"+ Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println(Thread.currentThread().getName() +"优先级:"+ Thread.currentThread().getPriority());
        t1.start();
        t2.start();
        System.out.println("stop Thread t in main");
        h.stopRunning();
        //for test
        while (i < 100) {
            System.out.println("Good Morning" + i++);
            /*if( i == 2 && t.isAlive()){
                System.out.println("Main waiting for Hello!");
                //等待t运行结束 意思是当i==2且t线程存活的时候Main线程停止 将t加入 t运行结束后Main重新开始运行
                t.join();
            }*/
        }
    }
}
