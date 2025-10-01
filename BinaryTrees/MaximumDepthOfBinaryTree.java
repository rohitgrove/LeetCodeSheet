public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(right, left) + 1;
    }

    public static void main(String[] args) {
        int data[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct = new ConstructTree();
        TreeNode root = ct.createTree(data);
        Traversals.levelOrderTraversal(root);
        System.out.println(maxDepth(root));
    }
}
