public class ConstructTree {
    private int idx;

    public ConstructTree() {
        this.idx = 0;
    }

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

    public void setIdx(int idx) {
        this.idx = idx;
    }
}
