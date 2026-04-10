package leetcodehot100_0309.测试;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子串长度 滑动窗口解法
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            else{
                max = Math.max(right - left + 1, max);
            }
            char ch = s.charAt(right);
            map.put(ch, right);
            right++;
        }

        return max;
    }

    // 主方法：测试用例入口
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "tmmzuxt";
        int res1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("测试用例1：输入字符串 \"" + s1 + "\"，最长无重复子串长度：" + res1); // 预期输出3

    }
}