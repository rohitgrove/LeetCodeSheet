import java.util.TreeMap;

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        int j = 0, i = 0, maxi = 0;
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        while (j < fruits.length) {
            mp.put(fruits[j], mp.getOrDefault(fruits[j], 0) + 1);

            if (mp.size() > 2) {
                mp.put(fruits[i], mp.get(fruits[i]) - 1);
                if (mp.get(fruits[i]) == 0) {
                    mp.remove(fruits[i]);
                }
                i++;
            }

            maxi = Math.max(maxi, j - i + 1);

            j++;
        }

        return maxi;
    }

    public static void main(String[] args) {
        int fruits1[] = { 1, 2, 1 };
        System.out.println(totalFruit(fruits1));
        int fruits2[] = { 0, 1, 2, 2 };
        System.out.println(totalFruit(fruits2));
        int fruits3[] = { 1, 2, 3, 2, 2 };
        System.out.println(totalFruit(fruits3));
    }
}
