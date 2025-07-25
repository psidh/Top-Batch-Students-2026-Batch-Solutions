
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        inorder(root);
    }

    static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            inorder(root.right);
            System.out.println(root.data);
        }
    }
}