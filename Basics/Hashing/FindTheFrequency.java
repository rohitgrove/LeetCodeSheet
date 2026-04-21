public class FindTheFrequency {
    public static int findFrequency(int arr[], int x) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 1, 1, 1, 1 };
        System.out.println(findFrequency(arr1, 1));
        int arr2[] = { 1, 2, 3, 3, 2, 1 };
        System.out.println(findFrequency(arr2, 2));
    }
}
