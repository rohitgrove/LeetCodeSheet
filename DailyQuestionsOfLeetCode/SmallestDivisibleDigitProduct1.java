public class SmallestDivisibleDigitProduct1 {
    public static int smallestNumber(int n, int t) {
        while(productOfDigits(n) % t != 0){
            n++;
        }
        return n;
    }

    public static int productOfDigits(int num){
        int product = 1;

        while(num != 0){
            product *= num % 10;
            num /= 10;
        }

        return product;
    }


    public static void main(String[] args) {
        System.out.println(smallestNumber(10, 2));
        System.out.println(smallestNumber(15, 3));
    }
}
