public class BalancedBinaryTree {
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(right, left) + 1;
    }

    public static boolean isBalancedHelper1(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHieght = height(root.left);
        int rightHieght = height(root.right);
        int diff = Math.abs(leftHieght - rightHieght);

        boolean currNode = (diff <= 1);

        boolean left = isBalancedHelper1(root.left);
        boolean right = isBalancedHelper1(root.right);

        return currNode && left && right;
    }

    static boolean isBalanced = true;
    public static int isBalancedHelper2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isBalancedHelper2(root.left);
        int right = isBalancedHelper2(root.right);

        if (isBalanced && Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return Math.max(right, left) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        isBalancedHelper2(root);
        return isBalanced;
    }

    public static void main(String[] args) {
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct = new ConstructTree();
        TreeNode root1 = ct.createTree(data1);
        System.out.println(Traversals.preorderTraversal(root1));
        System.out.println(isBalanced(root1));

        int data2[] = { 10, 20, 40, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, -1, -1 };
        ct.idx = 0;
        TreeNode root2 = ct.createTree(data2);
        System.out.println(Traversals.preorderTraversal(root2));
        System.out.println(isBalanced(root2));
    }
}
