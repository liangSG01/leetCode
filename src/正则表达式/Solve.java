package 正则表达式;
import java.util.*;
import java.util.regex.Pattern;

public class Solve {
    public static final String PATTERN_REX = "^(?:\\+86[-\\s])?"
            + "(?:1[3-9]\\d{9}|0\\d{2}[-\\s]\\d{8})$";
    public static final String PATTERN_REX2 = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*\\.[a-zA-Z]+$";
    public static void main(String[] args) {
        String phone = "13811111111";

        System.out.println(Pattern.matches(PATTERN_REX, phone));
    }
}
