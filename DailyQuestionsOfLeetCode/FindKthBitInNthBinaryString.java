public class FindKthBitInNthBinaryString {
    public static char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int len = (1 << n) - 1;
        int mid = (len + 1) / 2;

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            char bit = findKthBit(n - 1, len - k + 1);
            return (bit == '0') ? '1' : '0';
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
        System.out.println(findKthBit(4, 11));
    }
}
