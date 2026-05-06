public class FindSquareRoot {
    public static int mySqrt(int x) {
        int ans = -1;

        int s = 0;
        int e = x;
        long mid = s + (e - s) / 2;

        while (s <= e) {
            if ((mid * mid) == x) {
                return (int) mid;
            } else if ((mid * mid) < x) {
                ans = (int) mid;
                s = (int) mid + 1;
            } else {
                e = (int) mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(68));
    }
}
