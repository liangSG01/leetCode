package leetcodehot100_0309.有效括号;

import java.util.HashMap;
import java.util.LinkedList;

public class Solve {

    public static boolean func(String str){

        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            }
            else {
                Character ch = stack.pop();
                if(map.isEmpty()){
                    return false;
                }
                if (ch != map.get(str.charAt(i))){
                    return false;
                }
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {

    }
}
