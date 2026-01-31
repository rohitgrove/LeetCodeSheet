public class BinaryTreeMaximumSum {
    public static int maxPathSum(TreeNode root) {
        int ans[] = { Integer.MIN_VALUE };
        helper(root, ans);
        return ans[0];
    }

    public static int helper(TreeNode node, int ans[]) {
        if (node == null) {
            return 0;
        }

        // Get left and right max path sum; ignore negative paths
        int left = Math.max(helper(node.left, ans), 0);
        int right = Math.max(helper(node.right, ans), 0);

        // Compute the path sum passing through current node
        int pathSum = node.data + left + right;

        // Update global max
        ans[0] = Math.max(ans[0], pathSum);

        // Return max gain including current node to parent
        return node.data + Math.max(left, right);
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, -1, -1, 3, -1, -1 };
        TreeNode root1 = ct.createTree(data1);
        Traversals.preOrderTraversal(root1);
        System.out.println(" " + "MaxSum : " + maxPathSum(root1));
        int data2[] = { -10, 9, -1, -1, 20, 15, -1, -1, 17, -1, -1 };
        ct.idx = 0;
        TreeNode root2 = ct.createTree(data2);
        Traversals.preOrderTraversal(root2);
        System.out.println(" " + "MaxSum : " + maxPathSum(root2));
    }
}
