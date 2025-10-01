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
            TreeNode frontNode = q.poll();

            if (frontNode == null) {
                if (!q.isEmpty()) {
                    System.out.println();
                    q.offer(null);
                }
            } else {
                System.out.print(frontNode.val + " ");
                if (frontNode.left != null) {
                    q.offer(frontNode.left);
                }

                if (frontNode.right != null) {
                    q.offer(frontNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        // int data[] = { 10, 20, 40, 80, -1, -1, 90, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, 110, -1, -1, 120, -1, -1 };
        // int data[] = { 10, 20, 50, 65, -1, -1, 90, -1, -1, 70, -1, -1, 30, 60, -1, -1, 110, -1, -1 };
        // int data[] = { 10, 20, 40, -1, -1, -1, 30, 50, -1, -1, 60, -1, -1 };
        int data[] = { 10, 20, 40, -1, -1, 50, 90, -1, -1, 100, -1, -1, 30, 60, -1, -1, 70, -1, -1 };
        TreeNode root = ct.createTree(data);
        System.out.println();
        System.out.println("PreOrder: ");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("Inorder: ");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("PostOrder: ");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("LevelOrder: ");
        levelOrderTraversal(root);
        System.out.println();
    }
}
