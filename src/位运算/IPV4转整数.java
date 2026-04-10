package 位运算;

public class IPV4转整数 {
    // ipv4 转 整数
    public static long solve(String ipv4){
        long res = 0;
        String[] parts = ipv4.split("\\.");
        for(int i = 0; i < 4; i++){
            long part = Long.parseLong(parts[i]);
            res = res | part << (24 - i * 8);
        }
        return res;
    }
    public static String solve2(long num){
        String res = String.format("%d.%d.%d.%d",(num>>24)&0xff,(num>>16)&0xff,(num>>8)&0xff,num & 0xff);
        return res;
    }

    public static void main(String[] args) {
        String ipv4 = "192.168.1.10";
        long res1 = solve(ipv4);
        System.out.println(res1);

        long num = 3232235786L;
        String res2 = solve2(num);
        System.out.println(res2);
    }
}
