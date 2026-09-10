public class CountNodesEqualToAverageOfSubtree {
    static int ans = 0;

    public static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int sum = left[0] + right[0] + node.val;
        int cnt = left[1] + right[1] + 1;
        if (sum / cnt == node.val) {
            ans++;
        }
        return new int[] { sum, cnt };
    }

    public static void main(String[] args) {
        int firstAvg = (4 + 8 + 5 + 0 + 1 + 6) / 6;
        int secondAvg = (5 + 6) / 2;
        int thirdAvg = 0 / 1;
        int fourthAvg = 1 / 1;
        int fifthAvg = 6 / 1;

        System.out.println(firstAvg + " " + secondAvg + " " + thirdAvg + " " + fourthAvg + " " + fifthAvg);
        System.out.println(firstAvg / secondAvg / fourthAvg / fifthAvg);
    }
}
