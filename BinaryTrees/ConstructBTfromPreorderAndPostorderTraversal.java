public class ConstructBTfromPreorderAndPostorderTraversal {
    public static int findIndex(int[] arr, int value, int start) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // Not found
    }

    public static TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart,
            int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) {
            return root; // Leaf node
        }
        // Find index of left child in postorder
        int leftChildInPostorder = findIndex(postorder, preorder[preStart + 1], postStart);
        int leftSubtreeSize = leftChildInPostorder - postStart + 1;

        root.left = helper(preorder, postorder, preStart + 1, preStart + leftSubtreeSize, postStart,
                leftChildInPostorder);

        root.right = helper(preorder, postorder, preStart + leftSubtreeSize + 1, preEnd, leftChildInPostorder + 1,
                postEnd - 1);

        return root;
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public static void main(String[] args) {
        int preorder[] = { 1, 2, 4, 5, 3, 6, 7 }, postorder[] = { 4, 5, 2, 6, 7, 3, 1 };
        TreeNode root = constructFromPrePost(preorder, postorder);
        Traversals.levelOrderTraversal(root);
    }
}
