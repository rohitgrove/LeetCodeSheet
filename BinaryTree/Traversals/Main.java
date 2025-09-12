public class Main {
    public static void main(String[] args) {
        int data1[] = { 1, -1, 2, 3, -1, -1, -1 };
        ConstructTree ct = new ConstructTree();
        TreeNode root1 = ct.createTree(data1);
        System.out.println(Traversals.preorderTraversal(root1));
        System.out.println(Traversals.inorderTraversal(root1));
        System.out.println(Traversals.postorderTraversal(root1));

        int data2[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 6, -1, -1, -1 };
        ct.idx = 0;
        TreeNode root2 = ct.createTree(data2);
        System.out.println(Traversals.preorderTraversal(root2));
        System.out.println(Traversals.inorderTraversal(root2));
        System.out.println(Traversals.postorderTraversal(root2));
    }
}
