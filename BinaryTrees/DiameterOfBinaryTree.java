public class DiameterOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int option1 = diameterOfBinaryTree1(root.right);
        int option2 = diameterOfBinaryTree1(root.left);
        int option3 = maxDepth(root.left) + maxDepth(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }

    static int D = 0;

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        int currD = lh + rh;
        D = Math.max(currD, D);
        return Math.max(lh, rh) + 1;
    }

    public static int diameterOfBinaryTree2(TreeNode root) {
        height(root);
        return D;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        TreeNode root = ct.createTree(data);
        ct.levelOrderTraversal(root);

        System.out.println("Daimeter Of Tree: " + diameterOfBinaryTree2(root));
    }
}
