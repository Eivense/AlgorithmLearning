import java.util.Collection;
import java.util.LinkedHashSet;

public class Test {

    public static void main(String[] args) {

        int a=4;

        System.out.println(a<(a^2+1));
    }


    public static void test(Collection<String> collection) {
        for (String s : collection) {
            System.out.println(s);
        }
    }
}
