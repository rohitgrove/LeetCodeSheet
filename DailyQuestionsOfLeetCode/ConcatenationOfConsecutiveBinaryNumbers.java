public class ConcatenationOfConsecutiveBinaryNumbers {
    public static int concatenatedBinary(int n) {
        int shifter = 1;
        int val = 1;
        long answer = 0;
        int mod = 1_000_000_007;

        for (int a = 1; a <= n; a++) {
            if (val * 2 == a) {
                shifter++;
                val = a;
            }
            answer = ((answer << shifter) | a) % mod;
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1));
        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary(12));
    }
}
