public class ConstructTree {
    public int idx = 0;

    public TreeNode createTree(int data[]) {
        if (data[idx] == -1) {
            idx++;
            return null;
        }

        int val = data[idx++];
        TreeNode root = new TreeNode(val);
        root.left = createTree(data);
        root.right = createTree(data);
        return root;
    }
}
