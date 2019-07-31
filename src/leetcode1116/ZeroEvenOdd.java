package leetcode1116;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private Object lock = new Object();

    private volatile boolean flag=true;
    private volatile boolean odd=true;

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            synchronized (lock){
                if(!flag){
                    lock.wait();
                }
                printNumber.accept(0);
                flag=false;
                lock.notifyAll();
            }
        }
    }

    // 偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            synchronized (lock){
                while(flag||odd){
                    lock.wait();
                }
                printNumber.accept(i);
                flag=true;
                odd=true;
                lock.notifyAll();
            }
        }
    }

    // 奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            synchronized (lock){
                while(flag||!odd){
                    lock.wait();
                }
                printNumber.accept(i);
                flag=true;
                odd=false;
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
