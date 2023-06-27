import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/description/

public class S2 {

    public static void main(String[] args) {
        System.out.println(new S2().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        helper("(", 1, 0, n, list);

        return list;
    }

    public void helper(String s, int o, int c, int n, List<String> list) {

        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }

        if (o < n)
            helper(s + "(", o + 1, c, n, list);
        if (c < o)
            helper(s + ")", o, c + 1, n, list);
    }
}
