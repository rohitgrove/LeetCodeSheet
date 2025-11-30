import java.util.LinkedList;
import java.util.Queue;

public class RemoveHalfNodes {
    public static void removeNodes(TreeNode root, TreeNode node[]) {
        if (root == null) {
            return;
        }

        removeNodes(root.left, node);
        removeNodes(root.right, node);

        if (root.left != null && root.right == null && node[0] == null) {
            node[0] = root;
        } else if (root.left == null && root.right != null && node[0] == null) {
            node[0] = root;
        }
    }

    public static TreeNode removeHalfNodes(TreeNode root) {
        TreeNode node[] = { null };
        removeNodes(root, node);
        if (node[0] != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode topNode = q.poll();

                if (topNode.left != null) {
                    if (topNode.left == node[0]) {
                        if (node[0].left != null && node[0].right == null) {
                            topNode.left = node[0].left;
                        } else if (node[0].left == null && node[0].right != null) {
                            topNode.left = node[0].right;
                        }
                        break;
                    } else {
                        q.offer(topNode.left);
                    }
                }
                if (topNode.right != null) {
                    if (topNode.right == node[0]) {
                        if (node[0].left != null && node[0].right == null) {
                            topNode.left = node[0].left;
                        } else if (node[0].left == null && node[0].right != null) {
                            topNode.left = node[0].right;
                        }
                        break;
                    } else {
                        q.offer(topNode.right);
                    }
                }
            }

            return root;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 5, 7, 2, -1, -1, -1, 8, -1, -1 };
        TreeNode root1 = ct.createTree(data1);
        Traversals.inOrderTraversal(root1);
        removeHalfNodes(root1);
        System.out.println();
        Traversals.inOrderTraversal(removeHalfNodes(root1));
        ct.idx = 0;
        int data2[] = { 2, 7, -1, -1, 5, -1, -1 };
        TreeNode root2 = ct.createTree(data2);
        System.out.println();
        removeHalfNodes(root2);
        Traversals.inOrderTraversal(removeHalfNodes(root2));
    }
}
