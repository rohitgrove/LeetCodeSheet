import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimizeInversionsInAPrefixTree {
    public static int minInversions(String[] words, int[] target) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;

            for (char ch : words[i].toCharArray()) {
                int idx = ch - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
            }

            node.wordIndex = i;
        }

        dfs(root, target);
        return root.minInv;
    }

    public static void dfs(TrieNode node, int[] target) {
        List<TrieNode> children = new ArrayList<>();

        for (TrieNode child : node.children) {
            if (child != null) {
                dfs(child, target);
                children.add(child);
            }
        }

        int d = children.size();
        int fixed = 0;
        int internal = 0;

        if (node.wordIndex != -1) {
            int rank = target[node.wordIndex];

            for (TrieNode child : children) {
                fixed += lowerBound(child.ranks, rank);
            }
        }

        for (TrieNode child : children) {
            internal += child.minInv;
        }

        int[][] cross = new int[d][d];

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                if (i != j) {
                    cross[i][j] = countGreater(
                            children.get(i).ranks,
                            children.get(j).ranks);
                }
            }
        }

        int totalMasks = 1 << d;
        int[] dp = new int[totalMasks];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int mask = 0; mask < totalMasks; mask++) {
            for (int j = 0; j < d; j++) {
                if ((mask & (1 << j)) == 0) {
                    int added = 0;

                    for (int i = 0; i < d; i++) {
                        if ((mask & (1 << i)) != 0) {
                            added += cross[i][j];
                        }
                    }

                    int nextMask = mask | (1 << j);
                    dp[nextMask] = Math.min(
                            dp[nextMask],
                            dp[mask] + added);
                }
            }
        }

        node.minInv = fixed + internal + dp[totalMasks - 1];

        int size = node.wordIndex == -1 ? 0 : 1;

        for (TrieNode child : children) {
            size += child.ranks.length;
        }

        node.ranks = new int[size];
        int pos = 0;

        if (node.wordIndex != -1) {
            node.ranks[pos++] = target[node.wordIndex];
        }

        for (TrieNode child : children) {
            for (int rank : child.ranks) {
                node.ranks[pos++] = rank;
            }
        }

        Arrays.sort(node.ranks);
    }

    public static int countGreater(int[] a, int[] b) {
        int count = 0;

        for (int value : a) {
            count += lowerBound(b, value);
        }

        return count;
    }

    public static int lowerBound(int[] arr, int value) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        String[] words1 = { "bad", "bag", "fig", "fed" };
        int[] target1 = { 3, 1, 0, 2 };

        System.out.println(minInversions(words1, target1));
        String[] words2 = { "ab", "ac", "ba", "bc" };
        int[] target2 = { 0, 3, 1, 2 };

        System.out.println(minInversions(words2, target2));
    }
}
