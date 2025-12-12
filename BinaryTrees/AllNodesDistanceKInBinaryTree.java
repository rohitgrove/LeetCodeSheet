import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllNodesDistanceKInBinaryTree {
    public static void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parents) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parents.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents);

        HashMap<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        vis.put(target, true);

        int currDist = 0;
        while (currDist < k && !q.isEmpty()) {
            int size = q.size();
            currDist++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !vis.containsKey(node.left)) {
                    vis.put(node.left, true);
                    q.offer(node.left);
                }

                if (node.right != null && !vis.containsKey(node.right)) {
                    vis.put(node.right, true);
                    q.offer(node.right);
                }

                if (parents.containsKey(node) && !vis.containsKey(parents.get(node))) {
                    vis.put(parents.get(node), true);
                    q.offer(parents.get(node));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().data);
        }
        return ans;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data[] = { 3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1, 1, 0, -1, -1, 8, -1, -1 };
        TreeNode root = ct.createTree(data);
        Traversals.levelOrderTraversal(root);
        TreeNode target = root.left;
        System.out.println();
        System.out.println(distanceK(root, target, 2));
    }
}
