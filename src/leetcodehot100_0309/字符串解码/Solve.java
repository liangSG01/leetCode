package leetcodehot100_0309.字符串解码;

import java.util.LinkedList;

public class Solve {

    public static StringBuffer func(String str){
        StringBuffer res = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        int num = 0;
        LinkedList<StringBuffer> sbStack = new LinkedList<>();
        LinkedList<Integer> numStack = new LinkedList<>();
        for(char ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            else if (Character.isLetter(ch)){
                sb = sb.append(ch);
            }
            else if (ch == '['){
                numStack.push(num);
                sbStack.push(sb);
                num = 0;
                sb = new StringBuffer();
            }
            else if(ch == ']'){
                int nTemp = numStack.pop();
                StringBuffer strTemp = sbStack.pop();
                for(int i = 0; i < nTemp; i++){
                    strTemp.append(sb);
                }
                sb = strTemp;
            }
        }
        return sb;
    }
    public static void main(String[] args) {
        String str = "3[ab2[c]]";
        StringBuffer res = func(str);
        System.out.println(res);
    }
}
