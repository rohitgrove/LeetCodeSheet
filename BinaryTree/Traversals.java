import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    private static void postorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        postorderTraversalHelper(root.left, ans);
        postorderTraversalHelper(root.right, ans);
        ans.add(root.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalHelper(root, ans);
        return ans;
    }

    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                System.out.print(node.val + " ");
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int data1[] = { 1, -1, 2, 3, -1, -1, -1 };
        ConstructTree ct = new ConstructTree();
        TreeNode root1 = ct.createTree(data1);
        System.out.println("PreOrder: " + preorderTraversal(root1));
        System.out.println("InOrder: " + inorderTraversal(root1));
        System.out.println("postOrder: " + postorderTraversal(root1));
        System.out.print("bfs: ");
        bfs(root1);
        int data2[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1 };
        ct.idx = 0;
        TreeNode root2 = ct.createTree(data2);
        System.out.println("PreOrder: " + preorderTraversal(root2));
        System.out.println("InOrder: " + inorderTraversal(root2));
        System.out.println("postOrder: " + postorderTraversal(root2));
        System.out.print("bfs: ");
        bfs(root2);
    }
}
