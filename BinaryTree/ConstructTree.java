public class ConstructTree {
    int idx = 0;
    public TreeNode createTree(int data[]) {
        if (data[idx] == -1) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(data[idx++]);
        root.left = createTree(data);
        root.right = createTree(data);

        return root;
    }
}