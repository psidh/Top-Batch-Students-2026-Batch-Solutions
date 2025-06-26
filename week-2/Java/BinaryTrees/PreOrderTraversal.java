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

class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        inorder(root);
    }

    static void inorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            inorder(root.left);
            inorder(root.right);
        }
    }
}
