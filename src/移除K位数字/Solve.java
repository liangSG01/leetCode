package 移除K位数字;
import jdk.dynalink.beans.StaticClass;

import java.util.Deque;
import java.util.LinkedList;
import java.lang.StringBuilder;

class Solve {

    public static String removeKdigits(String num, int k) {
        int n = num.length();

        if (k == n) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }

        int leadingZeros = 0;
        while (leadingZeros < sb.length() && sb.charAt(leadingZeros) == '0') {
            leadingZeros++;
        }

        String result = sb.substring(leadingZeros);

        if (result.length() == 0) {
            return "0";
        }

        return result;
    }

    // --- Main 方法用于测试 ---
    public static void main(String[] args) {

        // 测试用例 1: 我们讨论的例子
        String num1 = "1432219";
        int k1 = 3;
        System.out.println("Input: num=" + num1 + ", k=" + k1);
        System.out.println("Output: " + removeKdigits(num1, k1)); // 预期: "1219"
        System.out.println("--------------------");

        // 测试用例 2: 前导零处理
        String num2 = "10200";
        int k2 = 1;
        System.out.println("Input: num=" + num2 + ", k=" + k2);
        System.out.println("Output: " + removeKdigits(num2, k2)); // 预期: "200"
        System.out.println("--------------------");

        // 测试用例 3: k 没用完 (递增序列)
        String num3 = "12345";
        int k3 = 2;
        System.out.println("Input: num=" + num3 + ", k=" + k3);
        System.out.println("Output: " + removeKdigits(num3, k3)); // 预期: "123"
        System.out.println("--------------------");

        // 测试用例 4: 结果是 "0"
        String num4 = "10";
        int k4 = 1;
        System.out.println("Input: num=" + num4 + ", k=" + k4);
        System.out.println("Output: " + removeKdigits(num4, k4)); // 预期: "0"
        System.out.println("--------------------");

        // 测试用例 5: 移除所有
        String num5 = "10";
        int k5 = 2;
        System.out.println("Input: num=" + num5 + ", k=" + k5);
        System.out.println("Output: " + removeKdigits(num5, k5)); // 预期: "0"
    }
}