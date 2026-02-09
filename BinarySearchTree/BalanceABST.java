import java.util.ArrayList;
import java.util.List;

public class BalanceABST {
    public static void inOrderTraversals(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }

        inOrderTraversals(root.left, inOrder);
        inOrder.add(root.val);
        inOrderTraversals(root.right, inOrder);
    }

    public static TreeNode builtBSTfromInOrder(List<Integer> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        int data = inOrder.get(mid);
        TreeNode root = new TreeNode(data);

        root.left = builtBSTfromInOrder(inOrder, start, mid - 1);
        root.right = builtBSTfromInOrder(inOrder, mid + 1, end);
        return root;
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversals(root, inOrder);
        return builtBSTfromInOrder(inOrder, 0, inOrder.size() - 1);
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 3, 4 };
        TreeNode root = CreateBST.createBST(data);
        System.out.println("Before balance BST: ");
        Traversals.levelOrderTraversal(root);
        System.out.println("After balance BST: ");
        Traversals.levelOrderTraversal(root);
    }
}