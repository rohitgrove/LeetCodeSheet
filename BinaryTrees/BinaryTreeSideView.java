import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ans.add(root.data);
        q.offer(null);

        while (!q.isEmpty()) {
            TreeNode frontNode = q.poll();

            if (frontNode == null) {
                if (!q.isEmpty()) {
                    ans.add(q.peek().data);
                    q.offer(null);
                }
            } else {
                if (frontNode.right != null) {
                    q.offer(frontNode.right);
                }

                if (frontNode.left != null) {
                    q.offer(frontNode.left);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, -1, 5, -1, -1, 3, -1, 4, -1, -1 };
        TreeNode root1 = ct.createTree(data1);
        Traversals.levelOrderTraversal(root1);
        System.out.println(rightSideView(root1));
        ct.idx = 0;
        int data2[] = { 1, 2, 4, 5, -1, -1, -1, -1, 3, -1, -1 };
        TreeNode root2 = ct.createTree(data2);
        Traversals.levelOrderTraversal(root2);
        System.out.println(rightSideView(root2));
    }
}
