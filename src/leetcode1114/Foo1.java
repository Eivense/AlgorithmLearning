package leetcode1114;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过锁实现
 */
public class Foo1 {

    private static Lock lock = new ReentrantLock();

    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    private static boolean first=false;
    private static boolean second=false;

    public Foo1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        printFirst.run();
        first=true;
        // 唤醒
        condition1.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        if(!first){
            //等待
            condition1.await();
        }
        printSecond.run();
        second=true;
        condition2.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        if(!second){
            condition2.await();
        }
        printThird.run();
        lock.unlock();
    }
}
