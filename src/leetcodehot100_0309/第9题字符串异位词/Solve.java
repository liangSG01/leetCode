package leetcodehot100_0309.第9题字符串异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solve {
    public static List<Integer> func(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < p.length()) return res;

        int[] pWindows = new int[128];
        int[] sWindows = new int[128];
        int k = p.length();

        for (char c : p.toCharArray()) {
            pWindows[c]++;
        }
        for (int right = 0; right < s.length(); right++) {

            sWindows[s.charAt(right)]++;

            // 步骤 2：出 (Remove) —— 如果当前遍历的元素数量超过了窗口大小 k，左侧老元素必须移出
            // 此时左侧元素的下标恰好是 right - k
            if (right >= k) {
                sWindows[s.charAt(right - k)]--;
            }

            // 步骤 3：算 (Process) —— 当窗口大小达到 k 时，开始记录/比较结果
            // 下标从 0 开始，所以当 right 走到 k - 1 时，窗口里正好有 k 个元素
            if (right >= k - 1) {
                if (Arrays.equals(pWindows, sWindows)) {
                    res.add(right - k + 1); // 记录起始索引 left
                }
            }
        }

        return res;
    }
public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if (s == null || s.length() < p.length()) {
        return res;
    }
    int[] pCount = new int[26];
    int[] sCount = new int[26];
    for (char c : p.toCharArray()) {
        pCount[c - 'a']++;
    }
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
        sCount[s.charAt(right) - 'a']++;
        if (right - left + 1 > p.length()) {
            sCount[s.charAt(left) - 'a']--;
            left++;
        }
        if (right - left + 1 == p.length() && Arrays.equals(pCount, sCount)) {
            res.add(left);
        }
    }

    return res;
}
    public static void main(String[] args) {
        String s = "cbabac";
        String p ="abc";
        System.out.println(func(s,p).toString());
    }
}
