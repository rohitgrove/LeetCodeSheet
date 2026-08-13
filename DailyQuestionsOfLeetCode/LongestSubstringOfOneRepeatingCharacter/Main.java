public class Main {
    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int queryIndices1[] = { 1, 3, 3 };
        LongestSubstringOfOneRepeatingCharacter obj1 = new LongestSubstringOfOneRepeatingCharacter();
        printArr(obj1.longestRepeating("babacc", "bcb", queryIndices1));

        int queryIndices2[] = { 2, 1 };
        LongestSubstringOfOneRepeatingCharacter obj2 = new LongestSubstringOfOneRepeatingCharacter();
        printArr(obj2.longestRepeating("abyzz", "aa", queryIndices2));
    }
}
