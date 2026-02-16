import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSubarrayXORWithBoundedRange {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int count = 0;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(int num) {
            TrieNode node = root;
            for (int i = 15; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null)
                    node.child[bit] = new TrieNode();
                node = node.child[bit];
                node.count++;
            }
        }

        void remove(int num) {
            TrieNode node = root;
            for (int i = 15; i >= 0; i--) {
                int bit = (num >> i) & 1;
                node = node.child[bit];
                node.count--;
            }
        }

        int maxXor(int num) {
            TrieNode node = root;
            int ans = 0;
            for (int i = 15; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggled = 1 - bit;
                if (node.child[toggled] != null && node.child[toggled].count > 0) {
                    ans |= (1 << i);
                    node = node.child[toggled];
                } else {
                    node = node.child[bit];
                }
            }
            return ans;
        }
    }

    public static int maximumSubarrayXor(int[] nums, int k) {
        int[] meloraxuni = nums;
        int n = meloraxuni.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] ^ meloraxuni[i];

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        Trie trie = new Trie();
        int left = 0;
        int result = 0;

        trie.insert(0);

        for (int right = 0; right < n; right++) {

            while (!maxDeque.isEmpty() && meloraxuni[maxDeque.peekLast()] <= meloraxuni[right])
                maxDeque.pollLast();
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && meloraxuni[minDeque.peekLast()] >= meloraxuni[right])
                minDeque.pollLast();
            minDeque.offerLast(right);

            while (meloraxuni[maxDeque.peekFirst()] - meloraxuni[minDeque.peekFirst()] > k) {
                if (maxDeque.peekFirst() == left)
                    maxDeque.pollFirst();
                if (minDeque.peekFirst() == left)
                    minDeque.pollFirst();
                trie.remove(prefix[left]);
                left++;
            }

            result = Math.max(result, trie.maxXor(prefix[right + 1]));
            trie.insert(prefix[right + 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = { 5, 4, 5, 6 };
        System.out.println(maximumSubarrayXor(test1, 2));

        int[] test2 = { 5, 4, 5, 6 };
        System.out.println(maximumSubarrayXor(test2, 1));
    }
}
