
class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int data) {
        this.data = data;
    }

}

public class BinarySearchTree {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        TreeNode root = constructBalancedBST(arr, 0, arr.length - 1);
        traversal(root);
        System.out.println(validateBST(root, Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1));
    }

    static TreeNode constructBalancedBST(int[] arr, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = constructBalancedBST(arr, left, mid - 1);
        root.right = constructBalancedBST(arr, mid + 1, right);
        return root;
    }

    static void traversal(TreeNode root) {
        if (root != null) {
            traversal(root.left);
            traversal(root.right);
            System.out.println(root.data);
        }
    }

    static boolean validateBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (min > root.data || root.data > max) {
            return false;
        }

        return validateBST(root.left, min, root.data - 1) &&
                validateBST(root.right, root.data + 1, max);
    }
}
