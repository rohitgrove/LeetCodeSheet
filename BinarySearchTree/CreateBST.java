public class CreateBST {
    private static TreeNode insertIntoBST(int data, TreeNode root) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (root.val > data) {
            root.right = insertIntoBST(data, root.right);
        } else {
            root.left = insertIntoBST(data, root.left);
        }

        return root;
    }

    public static TreeNode createBST(int data[]) {
        TreeNode root = null;
        for (int i = 0; i < data.length; i++) {
            root = insertIntoBST(data[i], root);
        }

        return root;
    }
}
