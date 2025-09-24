public class MaximumDepthOfTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(right, left) + 1;
    }

    public static void main(String[] args) {
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct = new ConstructTree();
        TreeNode root1 = ct.createTree(data1);
        System.out.println(Traversals.preorderTraversal(root1));
        System.out.println(maxDepth(root1));

        int data2[] = { 10, 20, 40, -1, -1, 50, 70, -1, -1, 80, -1, -1, 30, -1, 60, -1, -1 };
        ct.idx = 0;
        TreeNode root2 = ct.createTree(data2);
        System.out.println(Traversals.preorderTraversal(root2));
        System.out.println(maxDepth(root2));
    }
}
