package 最小覆盖子串;

public class Solve {
    public static String solve(String s, String p){
        // 1  2  3
        int[] countP = new int[26];
        int need = p.length();
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        for(int i = 0; i < p.length(); i++){
            countP[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while(right < s.length()){
            if(countP[s.charAt(right) - 'a'] > 0){
                need--;
            }
            countP[s.charAt(right) - 'a']--;
            right++;
            while(need == 0){
                if(min > right - left){
                    min = right - left;
                    minStart = left;
                }
                countP[s.charAt(left) - 'a']++;
                if(countP[s.charAt(left) - 'a'] > 0){
                    need++;
                }
                left++;
            }
        }
        if (min == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + min);

    }
    public static void main(String[] args) {
        String s = "abcdedfacd";
        String p = "acd";
        String result = solve(s,p);
        System.out.println(result);
    }
}
