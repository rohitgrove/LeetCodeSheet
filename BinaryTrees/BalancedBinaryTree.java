public class BalancedBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(right, left) + 1;
    }

    public static boolean isBalancedHelper1(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        boolean currNode = Math.abs(leftHeight - rightHeight) <= 1;

        boolean left = isBalancedHelper1(root.left);
        boolean right = isBalancedHelper1(root.right);
        return currNode && left && right;
    }

    private static boolean isBalanced = true;
    public static int isBalancedHelper2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isBalancedHelper2(root.left);
        int right = isBalancedHelper2(root.right);
        
        if (isBalanced && Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        isBalancedHelper2(root);
        return isBalanced;
    }

    public static void main(String[] args) {
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct = new ConstructTree();
        TreeNode root1 = ct.createTree(data1);
        Traversals.levelOrderTraversal(root1);
        System.out.println(isBalanced(root1));

        int data2[] = { 1, 2, 3, 4, -1, -1, 4, -1, -1, 3, -1, -1, 2, -1, -1 };
        ct.setIdx(0);
        TreeNode root2 = ct.createTree(data2);
        Traversals.levelOrderTraversal(root2);
        System.out.println(isBalanced(root2));
    }
}
