import java.util.HashMap;

public class ConstructTreeUsingPostOrderAndInOrder {
    public static void createMapping(int[] postorder, int size, HashMap<Integer, Integer> valueToIndex) {
        for (int i = 0; i < size; i++) {
            int element = postorder[i];
            int index = i;
            valueToIndex.put(element, index);
        }
    }

    public static TreeNode constructTreeFromPostAndInorderTraversal(HashMap<Integer, Integer> valueToIndexMap,
            int postOrder[], int inOrder[], int[] postIndex, int inOrderStart, int inOrderEnd, int size) {
        if (postIndex[0] < 0 || inOrderStart > inOrderEnd) {
            return null;
        }

        // 1 case main solve karunga
        int element = postOrder[postIndex[0]];
        postIndex[0]--;
        TreeNode root = new TreeNode(element);
        // search karo inoder main
        int position = valueToIndexMap.get(element);
        // baaki recursion sambhal lega
        // right ki call phele lagegi
        root.right = constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inOrder, postIndex, position + 1, inOrderEnd, size);
        root.left = constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inOrder, postIndex, inOrderStart, position - 1, size);
        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = postorder.length;
        int[] postIndex = { size - 1 };
        int inorderStart = 0;
        int inorderEnd = size - 1;
        HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
        createMapping(inorder, size, valueToIndexMap);
        return constructTreeFromPostAndInorderTraversal(valueToIndexMap, postorder, inorder, postIndex,
                inorderStart, inorderEnd, size);
    }

    public static void main(String[] args) {
        int inOrder[] = { 8, 14, 6, 2, 10, 4 };
        int postOrder[] = { 8, 6, 14, 4, 10, 2 };
        TreeNode root = buildTree(postOrder, inOrder);
        Traversals.levelOrderTraversal(root);
    }
}
