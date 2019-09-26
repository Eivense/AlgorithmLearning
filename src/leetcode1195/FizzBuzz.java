package leetcode1195;

import java.util.function.IntConsumer;

/**
 * 1195. Fizz Buzz Multithreaded
 * rite a program that outputs the string representation of numbers from 1 to n, however:
 *
 * If the number is divisible by 3, output "fizz".
 * If the number is divisible by 5, output "buzz".
 * If the number is divisible by both 3 and 5, output "fizzbuzz".
 * For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
 *
 * Suppose you are given the following code:
 *
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 * Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:
 *
 * Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
 * Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
 * Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
 * Thread D will call number() which should only output the numbers.
 *
 */
public class FizzBuzz {

    private Object lock = new Object();

    private volatile int state=0;

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=3;i<=n;i+=3){
            if(i%15==0)
                continue;
            synchronized (lock){
                while(state!=3){
                    lock.wait();
                }
                printFizz.run();
                state = 0;
                lock.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=5;i<=n;i+=5){
            if(i%15==0)
                continue;
            synchronized (lock){
                while(state!=5){
                    lock.wait();
                }
                printBuzz.run();
                state = 0;
                lock.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=15;i<=n;i+=15){
            synchronized (lock){
                while(state!=15){
                    lock.wait();
                }
                printFizzBuzz.run();
                state = 0;
                lock.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            synchronized (lock){
                while(state!=0){
                    lock.wait();
                }
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                } else {
                    if (i % 3 == 0) {
                        state = 3;
                    }
                    if (i % 5 == 0) {
                        state = 5;
                    }
                    if (i % 15 == 0) {
                        state = 15;
                    }
                    lock.notifyAll();
                }
            }
        }
    }


    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        //buzz
        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //fizz
        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
