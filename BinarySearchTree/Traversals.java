import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            TreeNode topNode = q.poll();
            if (topNode == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                System.out.print(topNode.val + " ");

                if (topNode.left != null) {
                    q.offer(topNode.left);
                }

                if (topNode.right != null) {
                    q.offer(topNode.right);
                }
            }
        }
    }
}
