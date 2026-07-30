public class MinimumNumberOfPushesToTypeWord1BruteForce {
//     Intuition
// Instead of deriving a formula, we can simply observe that:

// Characters at indices 0...7 require 1 push.
// Characters at indices 8...15 require 2 pushes.
// Characters at indices 16...23 require 3 pushes.
// Characters at indices 24...31 require 4 pushes.
// For every character,

// pushes = index / 8 + 1
// because every group of 8 characters increases the required push count by one.

// Dry Run
// word = "abcdefghij"
// Index	Pushes
// 0	1
// 1	1
// 2	1
// 3	1
// 4	1
// 5	1
// 6	1
// 7	1
// 8	2
// 9	2
// Total

// 1+1+1+1+1+1+1+1+2+2

// =12
// Complexity
// Time complexity: O(n)

// Space complexity: O(1)
    public static int minimumPushes(String word) {
        int pushes = 0;
        for (int i = 0; i < word.length(); i++) {
            pushes += (i / 8) + 1;
        }

        return pushes;
    }

    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));
        System.out.println(minimumPushes("abcdefghij"));
    }
}
