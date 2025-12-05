import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
    public int row;
    public int col;
    public TreeNode node;

    public Pair(int row, int col, TreeNode node) {
        this.row = row;
        this.col = col;
        this.node = node;
    }
}

public class VerticalOrderTraversalBT {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mapping = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, root));

        while (!q.isEmpty()) {
            Pair frontPair = q.poll();
            int frontRow = frontPair.row;
            int frontCol = frontPair.col;
            TreeNode frontNode = frontPair.node;

            mapping.putIfAbsent(frontCol, new TreeMap<>());
            mapping.get(frontCol).putIfAbsent(frontRow, new PriorityQueue<>());
            mapping.get(frontCol).get(frontRow).add(frontNode.data);

            if (frontNode.left != null) {
                q.offer(new Pair(frontRow + 1, frontCol - 1, frontNode.left));
            }

            if (frontNode.right != null) {
                q.offer(new Pair(frontRow + 1, frontCol + 1, frontNode.right));
            }
        }

        for (int col : mapping.keySet()) {
            TreeMap<Integer, PriorityQueue<Integer>> map = mapping.get(col);
            List<Integer> currList = new ArrayList<>();
            for (int row : map.keySet()) {
                PriorityQueue<Integer> pq = map.get(row);
                while (!pq.isEmpty()) {
                    currList.add(pq.poll());
                }
            }
            ans.add(currList);
        }

        return ans;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        TreeNode root1 = ct.createTree(data1);
        Traversals.levelOrderTraversal(root1);
        System.out.println(verticalTraversal(root1));

        ct.idx = 0;
        int data2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        TreeNode root2 = ct.createTree(data2);
        Traversals.levelOrderTraversal(root2);
        ct.idx = 0;
        System.out.println(verticalTraversal(root2));

        int data3[] = { 1, 2, 4, -1, -1, 6, -1, -1, 3, 5, -1, -1, 7, -1, -1 };
        TreeNode root3 = ct.createTree(data3);
        Traversals.levelOrderTraversal(root3);
        System.out.println(verticalTraversal(root3));
    }
}
