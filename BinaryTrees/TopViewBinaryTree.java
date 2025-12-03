import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
    public int hd;
    public TreeNode node;

    public Pair(int hd, TreeNode node) {
        this.hd = hd;
        this.node = node;
    }
}

public class TopViewBinaryTree {
    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeMap<Integer, Integer> hdToNode = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair frontPair = q.poll();
            int hd = frontPair.hd;
            TreeNode frontNode = frontPair.node;

            hdToNode.putIfAbsent(hd, frontNode.data);

            if (frontNode.left != null) {
                q.offer(new Pair(hd - 1, frontNode.left));
            }

            if (frontNode.right != null) {
                q.offer(new Pair(hd + 1, frontNode.right));
            }
        }

        ans.addAll(hdToNode.values());
        return ans;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data[] = { 10, 20, 40, -1, -1, 60, -1, -1, 30, 90, -1, -1, 100, -1, -1 };
        TreeNode root = ct.createTree(data);
        Traversals.levelOrderTraversal(root);
        System.out.println(topView(root));
    }
}
