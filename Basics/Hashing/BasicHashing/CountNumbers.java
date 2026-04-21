public class CountNumbers {
    public static void hashing(int arr[]) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum, arr[i]);
        }

        int hash[] = new int[maximum + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                System.out.println(i + " " + hash[i]);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 3, 12, 3, 4, 6, 4, 6 };
        hashing(arr);
    }
}
