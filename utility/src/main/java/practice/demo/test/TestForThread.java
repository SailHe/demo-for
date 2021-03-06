package practice.demo.test;

/**
 * Descriptions: 线程测试<p>
 *
 * @author SailHe
 * @date 2018/11/11 17:57
 */
class HelloWorldForThread implements Runnable {
    private int i = 0;
    private boolean timeToQuit = false;

    @Override
    public void run() {
        while (!timeToQuit) {
            System.out.println(Thread.currentThread().getName() +"优先级:"+ Thread.currentThread().getPriority() + " HelloWorldForThread" + i);
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
    /**
     * Descriptions: 标识符id可以用来区分任务的多个实例，它是final的，因为它一旦被初始化之后就不希望被修改。<p>
     *
     * @author SailHe
     * @date 2018/11/11 17:58
     */
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"("+
                (countDown > 0 ? countDown : "LiftOff") + "), ";
    }
    /**
     * Descriptions: 任务的run（）方法通常总会有某种形式的循环，使得任务一直运行下去直到不再需要，所以
     * 要设定跳出循环的条件（有一种选择是直接从run（）返回）。通常， ·run（）被写成无限循环的形式，
     * 这就意味着，除非有某个条件使得run（）终止，否则它将永远运持下去<p>
     *
     * @author SailHe
     * @date 2018/11/11 17:58
     */
    @Override
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

/**
 * Descriptions: 游乐场<p>
 *
 * @author SailHe
 * @date 2018/11/11 17:59
 */
public class TestForThread {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");


        HelloWorldForThread h = new HelloWorldForThread();
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
        int maxCnt = 100;
        //for test
        while (i < maxCnt) {
            System.out.println("Good Morning" + i++);
            /*if( i == 2 && t.isAlive()){
                System.out.println("Main waiting for HelloWorldForThread!");
                //等待t运行结束 意思是当i==2且t线程存活的时候Main线程停止 将t加入 t运行结束后Main重新开始运行
                t.join();
            }*/
        }
    }
}
