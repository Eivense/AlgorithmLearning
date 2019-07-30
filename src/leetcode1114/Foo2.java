package leetcode1114;

public class Foo2 {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private boolean first=false;
    private boolean second=false;


    public Foo2(){

    }
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.

        synchronized (lock1){
            printFirst.run();
            first=true;
            lock1.notify();
        }


    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock1){
            if(!first){
                lock1.wait();
            }
            synchronized (lock2){
                printSecond.run();
                second=true;
                lock2.notify();
            }
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock2){
            if(!second){
                lock2.wait();
            }
            printThird.run();
        }
    }
}
