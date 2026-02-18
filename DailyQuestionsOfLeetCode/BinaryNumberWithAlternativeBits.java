import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryNumberWithAlternativeBits {
    public static boolean hasAlternatingBits(int n) {
        List<Integer> bits = new ArrayList<>();
        while (n > 0) {
            int bit = n & 1;
            bits.addFirst(bit);
            n = n >> 1;
        }

        for (int i = 0; i < bits.size() - 1; i++) {
            if (Objects.equals(bits.get(i), bits.get(i + 1))) {
                return false;
            }
        }

        return true;
    }

    public static boolean hasAlternatingBitsM2(int n) {
        int prevBit = n & 1;
        n = n >> 1;

        while (n > 0) {
            int currBit = n & 1;

            if (currBit == prevBit) {
                return false;
            }

            prevBit = currBit;
            n = n >> 1;
        }

        return true;
    }

    public static boolean hasAlternatingBitsM3(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }


    public static void main(String[] args) {
        System.out.println(hasAlternatingBitsM3(5));
        System.out.println(hasAlternatingBitsM3(7));
        System.out.println(hasAlternatingBitsM3(11));
    }
}
