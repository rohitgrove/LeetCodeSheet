public class FindUniquesBinaryString {
    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int size = (int) Math.pow(2, n);

        int[] nu = new int[size];

        for (String num : nums) {
            int val = Integer.parseInt(num, 2);
            nu[val]++;
        }

        for (int i = 0; i < size; i++) {
            if (nu[i] == 0) {
                String ans = Integer.toBinaryString(i);
                return "0".repeat(n - ans.length()) + ans;
            }
        }

        return "0".repeat(n);
    }

    public static void main(String[] args) {
        String nums1[] = { "01", "10" };
        System.out.println(findDifferentBinaryString(nums1));
        String nums2[] = { "00", "01" };
        System.out.println(findDifferentBinaryString(nums2));
        String nums3[] = { "111", "011", "001" };
        System.out.println(findDifferentBinaryString(nums3));
    }
}
