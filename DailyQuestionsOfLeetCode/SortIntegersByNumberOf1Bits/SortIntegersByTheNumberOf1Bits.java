import java.util.PriorityQueue;

public class SortIntegersByTheNumberOf1Bits {
    public static int[] sortByBits(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Compare());

        for (int ele : arr) {
            pq.offer(new Pair(Integer.bitCount(ele), ele));
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            Pair top = pq.poll();

            arr[idx++] = top.element;
        }

        return arr;
    }

    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        printArr(sortByBits(arr1));
        int arr2[] = { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 };
        printArr(sortByBits(arr2));
    }
}
