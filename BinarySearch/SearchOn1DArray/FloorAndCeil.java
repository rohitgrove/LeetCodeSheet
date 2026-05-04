public class FloorAndCeil {
    public static int findFloor(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (arr[mid] <= target) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static int findCeil(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int ans = arr.length;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (arr[mid] >= target) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static int[] getFloorAndCeil(int[] arr, int target) {
        int f = findFloor(arr, target);
        int c = findCeil(arr, target);
        return new int[] { f, c };
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 7, 8, 10 };
        int x = 5;
        int[] res = getFloorAndCeil(arr, x);
        System.out.println("The floor and ceil are: " + res[0] + " " + res[1]);
    }
}
