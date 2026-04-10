package leetcodehot100_0309.划分字母区间;

import java.util.ArrayList;
import java.util.List;

public class Solve {

    public static List<Integer> func(String str) {
        // abcaaede
        int last[] = new int[128];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            last[str.charAt(i)] = i;
        }
        int max = last[str.charAt(0)];
        int left = 0;
        for(int right = 1; right < str.length(); right++){
            if(right == max){
                res.add(right - left + 1);
                left = right + 1;
            }
            max = Math.max(max, last[str.charAt(right)]);
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "abcaaede";
        List<Integer> res = func(str);
        System.out.println(res);
    }
}
