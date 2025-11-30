public class Main {
    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        // int data[] = { 10, 20, 40, 80, -1, -1, 90, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, 110, -1, -1, 120, -1, -1 };
        // int data[] = { 10, 20, 50, 65, -1, -1, 90, -1, -1, 70, -1, -1, 30, 60, -1, -1, 110, -1, -1 };
        // int data[] = { 10, 20, 40, -1, -1, -1, 30, 50, -1, -1, 60, -1, -1 };
        int data[] = { 10, 20, 40, -1, -1, 50, 90, -1, -1, 100, -1, -1, 30, 60, -1, -1, 70, -1, -1 };
        TreeNode root = ct.createTree(data);
        System.out.println(root.data);
        System.out.println();
        System.out.println("PreOrder: ");
        Traversals.preOrderTraversal(root);
        System.out.println();
        System.out.println("Inorder: ");
        Traversals.inOrderTraversal(root);
        System.out.println();
        System.out.println("PostOrder: ");
        Traversals.postOrderTraversal(root);
        System.out.println();
        System.out.println("LevelOrder: ");
        Traversals.levelOrderTraversal(root);
        System.out.println();
    }
}
