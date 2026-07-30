public class MinimumNumberOfPushesToTypeWord1OptimizedApproach {
    // Intuition
    // A keypad has only 8 buttons (2 to 9).

    // To minimize the total pushes:

    // The first 8 letters should require 1 push.
    // The next 8 letters should require 2 pushes.
    // The next 8 letters should require 3 pushes.
    // The remaining letters require 4 pushes.
    // So instead of simulating every character, we divide the letters into blocks
    // of size 8.

    // Block 1 : 8 letters → 1 push each
    // Block 2 : 8 letters → 2 pushes each
    // Block 3 : 8 letters → 3 pushes each
    // Block 4 : Remaining → 4 pushes each
    // For a word of length n:

    // Number of complete blocks
    // blocks = n / 8
    // Remaining letters
    // remaining = n % 8
    // The total pushes contributed by complete blocks are

    // 8×1 + 8×2 + ... + 8×blocks
    // Using the sum of first blocks natural numbers,

    // 8 × (1 + 2 + ... + blocks)

    // = 8 × blocks × (blocks + 1) / 2

    // = 4 × blocks × (blocks + 1)
    // The remaining letters all belong to the next block.

    // So each contributes

    // blocks + 1
    // pushes.

    // Hence,

    // Answer

    // = 4 × blocks × (blocks + 1)

    // + remaining × (blocks + 1)
    // Dry Run

    // Input
    // word = "abcdefghij"
    // Length = 10

    // blocks = 10 / 8 = 1
    // remaining = 10 % 8 = 2
    // Complete block:

    // 8 letters × 1 push = 8
    // Remaining:

    // 2 letters × 2 pushes = 4
    // Answer

    // 8 + 4 = 12
    // Complexity
    // Time complexity: O(1)

    // Space complexity: O(1)
    public static int minimumPushes(String word) {
        int n = word.length();
        int blocks = n / 8;
        return (blocks * (blocks + 1) * 4)
                + (n % 8) * (blocks + 1);
    }

    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));
        System.out.println(minimumPushes("abcdefghij"));
    }
}
