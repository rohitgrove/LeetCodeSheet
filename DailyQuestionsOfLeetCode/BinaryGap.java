public class BinaryGap {
    public static int binaryGap(int n) {
        int last = -1, pos = 0, ans = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, pos - last);
                }
                last = pos;
            }
            n >>= 1;
            pos++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(8));
        System.out.println(binaryGap(5));
    }
}
