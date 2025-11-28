public class BalancedBinaryTree {
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static boolean isBalancedHelper(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isBalancedHelper(root.left);
        boolean right = isBalancedHelper(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        boolean isBalanced = Math.abs(rightHeight - leftHeight) <= 1;

        return left && right && isBalanced;
    }

    static boolean isBalancedTree = true;

    public static int isBalancedHelper2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isBalancedHelper2(root.left);
        int right = isBalancedHelper2(root.right);

        if (Math.abs(right - left) > 1 && isBalancedTree) {
            isBalancedTree = false;
        }

        return Math.max(right, left) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        isBalancedHelper2(root);
        return isBalancedTree;
    }

    public static void main(String[] args) {
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct = new ConstructTree();
        TreeNode root1 = ct.createTree(data1);
        System.out.println(isBalanced(root1));
        ct.idx = 0;
        int data2[] = { 1, 2, 3, 4, -1, -1, 4, -1, -1, 3, -1, -1, 2, -1, -1 };
        TreeNode root2 = ct.createTree(data2);
        System.out.println(isBalanced(root2));
    }
}
