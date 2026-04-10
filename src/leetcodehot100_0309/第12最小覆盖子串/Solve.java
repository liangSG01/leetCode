package leetcodehot100_0309.第12最小覆盖子串;
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 ||s.length() == 0 ){
            return "";
        }
        int needCnt = t.length();
        int i = 0,j = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int[] need = new int[128];
        for (char c : t.toCharArray()){
            need[c]++;
        }
        while (j < s.length()){
            int cj = s.charAt(j);
            if(need[cj] > 0) needCnt --;
            need[cj] --;
            while(needCnt == 0){
                if (j - i + 1 < minLen){
                    minLen = j  - i + 1;
                    minStart = i;
                }
                need[s.charAt(i)]++;
                if (need[s.charAt(i)] > 0) {
                    needCnt++;
                }
                i++;
            }
            j++;
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen);
    }
}
