import java.util.Stack;

class Node {
    String val;
    Node left, right;

    Node(String val) {
        this.val = val;
    }
}

public class EvalPostfix {
    public static Node constructTree(String[] postfix) {
        Stack<Node> st = new Stack<>();

        for (String token : postfix) {
            if (operator(token)) {
                Node right = st.pop();
                Node left = st.pop();
                Node node = new Node(token);
                node.left = left;
                node.right = right;
                st.push(node);
            } else {
                st.push(new Node(token));
            }
        }
        return st.pop();
    }

    private static boolean operator(String token) {
        return (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/"));

    }

    private static int evaluate(Node root) {
        if (root == null) {
            return 0;

        }

        if (!operator(root.val)) {
            return Integer.parseInt(root.val);
        }

        int leftVal = evaluate(root.left);
        int rightVal = evaluate(root.right);

        return applyOperator(leftVal, rightVal, root.val);

    }

    private static int applyOperator(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public static void main(String[] args) {
        String[] postfix = { "3", "4", "+", "2", "*", "7", "/" };
        Node root = constructTree(postfix);
        int result = evaluate(root);
        System.out.println("Result: " + result); // ((3 + 4) * 2) / 7 = 2
    }
}
