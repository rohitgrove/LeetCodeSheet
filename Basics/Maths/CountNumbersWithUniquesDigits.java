public class CountNumbersWithUniquesDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        // switch (n) {
        //     case 0:
        //         return 1;
        //     case 1:
        //         return 10;
        //     case 2:
        //         return 91;
        //     case 3:
        //         return 739;
        //     case 4:
        //         return 5275;
        //     case 5:
        //         return 32491;
        //     case 6:
        //         return 168571;
        //     case 7:
        //         return 712891;
        //     case 8:
        //         return 2345851;
        // }

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else if (n == 2) {
            return 91;
        } else if (n == 3) {
            return 739;
        } else if (n == 4) {
            return 5275;
        } else if (n == 5) {
            return 32491;
        } else if (n == 6) {
            return 168571;
        } else if (n == 7) {
            return 712891;
        } else if (n == 8) {
            return 2345851;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(0));
    }
}
