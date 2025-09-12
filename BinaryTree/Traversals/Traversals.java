import java.util.ArrayList;
import java.util.List;

public class Traversals {
    private static void preorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        preorderTraversalHelper(root.left, ans);
        preorderTraversalHelper(root.right, ans);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversalHelper(root, ans);
        return ans;
    }

    private static void inorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        inorderTraversalHelper(root.left, ans);
        ans.add(root.val);
        inorderTraversalHelper(root.right, ans);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalHelper(root, ans);
        return ans;
    }
}
