public class ConstructBTfromPreorderAndInorderTaversal {
    public static int findPositionInInOrder(int[] inorder, int element, int size) {
        for (int i = 0; i < size; i++) {
            if (inorder[i] == element) {
                return i;
            }
        }

        return -1;
    }

    public static TreeNode constructTreeFromPreOrderAndPostOrder(int preorder[], int inorder[], int preIndex[],
            int inStart, int inEnd, int size) {
        if (preIndex[0] >= size || inStart > inEnd) {
            return null;
        }

        int element = preorder[preIndex[0]];
        preIndex[0]++;
        TreeNode root = new TreeNode(element);
        int position = findPositionInInOrder(inorder, element, size);

        root.left = constructTreeFromPreOrderAndPostOrder(preorder, inorder, preIndex, inStart, position - 1, size);
        root.right = constructTreeFromPreOrderAndPostOrder(preorder, inorder, preIndex, position + 1, inEnd, size);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preIndex[] = { 0 };
        int inorderStart = 0;
        int inorderEnd = inorder.length - 1;
        int size = preorder.length;
        return constructTreeFromPreOrderAndPostOrder(preorder, inorder, preIndex, inorderStart, inorderEnd, size);
    }

    public static void main(String[] args) {
        int preorder[] = { 3, 9, 20, 15, 7 }, inorder[] = { 9, 3, 15, 20, 7 };
        ConstructTree ct = new ConstructTree();
        ct.levelOrderTraversal(buildTree(preorder, inorder));
    }
}
