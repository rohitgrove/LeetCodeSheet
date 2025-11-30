public class SubTreeForAnotherTree {
    public static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        boolean left = isSame(p.left, q.left);
        boolean right = isSame(p.right, q.right);
        boolean cond = p.data == q.data;

        return left && right && cond;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (isSame(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int Root[] = { 3, 4, 1, -1, -1, 2, -1, -1, 5, -1, -1 }, SubRoot[] = { 4, 1, -1, -1, 2, -1, -1 };
        TreeNode root = ct.createTree(Root);
        ct.idx = 0;
        TreeNode subRoot = ct.createTree(SubRoot);
        System.out.println(isSubtree(root, subRoot));
    }
}
