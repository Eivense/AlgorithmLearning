package meituan.meituan001;

import java.util.Scanner;

/**
 * @author Eivense
 * @date 2021/9/22 11:25 下午
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            if (check(name)) {
                System.out.println("Accept");
            }else{
                System.out.println("Wrong");
            }
        }
    }

    public static boolean check(String name) {
        char first = name.charAt(0);
        // 首字母
        if (!(first >= 'a' && first <= 'z' || first >= 'A' && first <= 'Z')) {
            return false;
        }
        boolean digit = false;
        for (int i = 1; i < name.length(); i++) {
            char c = name.charAt(i);
            // 包含数字
            if (c >= '0' && c <= '9') {
                digit = true;
            }else if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                continue;
            }else{
                return false;
            }
        }
        return digit;
    }
}
