
import java.util.Stack;

class EvaluateExpression {
    public static void main(String[] args) {
        System.out.println(eval("{()]}"));
    }

    static boolean eval(String str) {
        Stack<Character> st = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.peek() != '(') {
                    return false;
                }
                st.pop();

            } else if (ch == ']') {
                if (st.peek() != '[') {
                    return false;
                }
                st.pop();
            } else if (ch == '}') {
                if (st.peek() != '{') {
                    return false;
                }
                st.pop();
            }
        }
        return st.empty();
    }
}
