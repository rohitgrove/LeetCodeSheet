public class FruitIntoBaskets2 {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, cnt = 0;
        for (int fruit : fruits) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruit) {
                    baskets[j] = 0;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int fruits1[] = { 4, 2, 5 }, baskets1[] = { 3, 5, 4 };
        System.out.println(numOfUnplacedFruits(fruits1, baskets1));
        int fruits2[] = { 3, 6, 1 }, baskets2[] = { 6, 4, 7 };
        System.out.println(numOfUnplacedFruits(fruits2, baskets2));
    }
}
