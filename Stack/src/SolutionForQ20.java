import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class SolutionForQ20 {

    public boolean isValid(String s) {
        // 使用栈来维护当前的括号信息
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                // 将所有的左括号依次入栈
                stack.push(c);
            } else {

                // 直接传入右括号，不通过
                if (stack.isEmpty()) {
                    return false;
                }

                // 匹配到右括号时，将栈顶元素出栈，查看是否能正确闭合
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
            }
        }
        // 正确的场景应该是，所有的括号全部匹配成功，栈内不留元素
        // 如果栈不为空，则说明传入的为奇数个括号
        return stack.isEmpty();
    }

}
