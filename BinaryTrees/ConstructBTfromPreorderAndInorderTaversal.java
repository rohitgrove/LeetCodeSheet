import java.util.HashMap;

public class ConstructBTfromPreorderAndInorderTaversal {
    public static int findPositionInInOrder(int[] inorder, int element, int size) {
        for (int i = 0; i < size; i++) {
            if (inorder[i] == element) {
                return i;
            }
        }

        return -1;
    }

    public static void inOrderMappingToIndex(HashMap<Integer, Integer> indexMap, int inOrder[]) {
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
    }

    public static TreeNode constructTreeFromPreOrderAndPostOrder(int preorder[], int inorder[], int preIndex[],
            int inStart, int inEnd, int size, HashMap<Integer, Integer> indexMap) {
        if (preIndex[0] >= size || inStart > inEnd) {
            return null;
        }

        int element = preorder[preIndex[0]];
        preIndex[0]++;
        TreeNode root = new TreeNode(element);
        int position = indexMap.get(element);

        root.left = constructTreeFromPreOrderAndPostOrder(preorder, inorder, preIndex, inStart, position - 1, size, indexMap);
        root.right = constructTreeFromPreOrderAndPostOrder(preorder, inorder, preIndex, position + 1, inEnd, size, indexMap);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preIndex[] = { 0 };
        int inorderStart = 0;
        int inorderEnd = inorder.length - 1;
        int size = preorder.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        inOrderMappingToIndex(indexMap, inorder);
        return constructTreeFromPreOrderAndPostOrder(preorder, inorder, preIndex, inorderStart, inorderEnd, size, indexMap);
    }

    public static void main(String[] args) {
        int preorder[] = { 3, 9, 20, 15, 7 }, inorder[] = { 9, 3, 15, 20, 7 };
        ConstructTree ct = new ConstructTree();
        ct.levelOrderTraversal(buildTree(preorder, inorder));
    }
}
