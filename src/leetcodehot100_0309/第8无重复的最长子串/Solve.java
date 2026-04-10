package leetcodehot100_0309.第8无重复的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Solve {
    public static int func(String str){
        int res = 0;
        char[] chars = str.toCharArray();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++){
            if (map.containsKey(chars[i])){
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            res = Math.max(res, i - left + 1);
            map.put(chars[i], i);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(func("bbbbb"));
    }
}
