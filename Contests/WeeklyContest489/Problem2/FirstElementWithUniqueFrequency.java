import java.util.HashMap;

public class FirstElementWithUniqueFrequency {
    public static int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> freqCount = new HashMap<>();

        for (int count : freq.values()) {
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }

        for (int num : nums) {
            int count = freq.get(num);
            if (freqCount.get(count) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = { 20, 10, 30, 30 };
        System.out.println(firstUniqueFreq(test1));

        int[] test2 = { 20, 20, 10, 30, 30, 30 };
        System.out.println(firstUniqueFreq(test2));

        int[] test3 = { 10, 10, 20, 20 };
        System.out.println(firstUniqueFreq(test3));
    }
}
