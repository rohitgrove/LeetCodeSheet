import java.util.LinkedList;
import java.util.Queue;

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

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrderTraversal(TreeNode root) {
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
                System.out.print(topNode.data + " ");

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
