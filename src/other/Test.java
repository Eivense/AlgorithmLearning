package other;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class A {
    int a = 0;

    public A(int a) {
        this.a = a;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}

public class Test {

    public static void main(String[] args) throws Exception {
        String a = "java";

        String b = new String("java");

        String c = new StringBuilder().append("java").toString();

        System.out.println(a == b.intern());
        System.out.println(b == c);
        System.out.println(a == c);

    }
}
