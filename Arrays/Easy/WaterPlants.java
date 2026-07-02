public class WaterPlants {
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int start = 0;
        int end = plants.length - 1;

        int capA = capacityA;
        int capB = capacityB;

        int refill = 0;

        while (start < end) {
            // Alice
            if (capA >= plants[start]) {
                capA -= plants[start];
            } else {
                refill++;
                capA = capacityA - plants[start];
            }
            start++;

            // Bob
            if (capB >= plants[end]) {
                capB -= plants[end];
            } else {
                refill++;
                capB = capacityB - plants[end];
            }
            end--;
        }

        // Same plant left
        if (start == end) {
            if (capA >= capB) {
                if (capA < plants[start]) {
                    refill++;
                }

            } else {
                if (capB < plants[start]) {
                    refill++;
                }
            }
        }

        return refill;
    }

    public static void main(String[] args) {
        int[] plants1 = { 2, 2, 3, 3 };
        System.out.println(minimumRefill(plants1, 5, 5)); // 1

        int[] plants2 = { 2, 2, 3, 3 };
        System.out.println(minimumRefill(plants2, 3, 4)); // 2

        int[] plants3 = { 5 };
        System.out.println(minimumRefill(plants3, 10, 8)); // 0
    }
}