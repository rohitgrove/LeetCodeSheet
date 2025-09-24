public class Main {
    public static void main(String[] args) {
        int data1[] = { 1, -1, 2, 3, -1, -1, -1 };
        ConstructTree ct = new ConstructTree();
        TreeNode root1 = ct.createTree(data1);
        System.out.println("PreOrder: " + Traversals.preorderTraversal(root1));
        System.out.println("InOrder: " + Traversals.inorderTraversal(root1));
        System.out.println("postOrder: " + Traversals.postorderTraversal(root1));
        System.out.print("bfs: ");
        Traversals.bfs(root1);
        int data2[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1 };
        ct.idx = 0;
        TreeNode root2 = ct.createTree(data2);
        System.out.println("PreOrder: " + Traversals.preorderTraversal(root2));
        System.out.println("InOrder: " + Traversals.inorderTraversal(root2));
        System.out.println("postOrder: " + Traversals.postorderTraversal(root2));
        System.out.print("bfs: ");
        Traversals.bfs(root2);
    }
}
