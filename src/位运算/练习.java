package 位运算;

public class 练习 {
    public static long solve(String ipv4){
        long res = 0;
        String[] ch = ipv4.split("\\.");
        int i = 0;
        for(String part : ch){
            Long num = Long.parseLong(part);
            res = res | num << 24 - 8 * i;
            i++;
        }
        return res;
    }
    public static String solve2(long num){
        String res = String.format("%d.%d.%d.%d",(num>>24)&0xff,(num>>16)&0xff,(num>>8)&0xff,num & 0xff);
        return res;
    }

    
    public static void main(String[] args) {

    }

}
