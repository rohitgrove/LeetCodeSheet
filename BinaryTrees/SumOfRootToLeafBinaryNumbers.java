public class SumOfRootToLeafBinaryNumbers {
    public static int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }

        current = current * 2 + node.data;

        if (node.left == null && node.right == null) {
            return current;
        }

        return dfs(node.left, current) + dfs(node.right, current);
    }

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data[] = { 1, 0, 0, -1, -1, 1, -1, -1, 1, 0, -1, -1, 1, -1, -1 };
        TreeNode root = ct.createTree(data);
        System.out.println(sumRootToLeaf(root));
    }
}
