public class CountCompleteTree {
    public static void countNodesHelper(TreeNode root, int count[]) {
        if (root == null) {
            return;
        }

        countNodesHelper(root.left, count);
        count[0]++;
        countNodesHelper(root.right, count);
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count[] = { 0 };
        countNodesHelper(root, count);
        return count[0];
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, -1 };
        TreeNode root = ct.createTree(data);
        Traversals.levelOrderTraversal(root);
        System.out.println(countNodes(root));
    }
}
