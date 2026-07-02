public class WaterPlants {
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int start = 0;
        int end = plants.length - 1;

        int cntRefil = 0;

        int capA = capacityA;
        int capB = capacityB;

        while (start < end) {
            // Alice
            if (plants[start] <= capA) {
                capA -= plants[start];
            } else {
                cntRefil++;
                capA = capacityA - plants[start];
            }
            start++;
            // Bob
            if (plants[end] <= capB) {
                capB -= plants[end];
            } else {
                cntRefil++;
                capB = capacityB - plants[end];
            }
            end--;
        }

        // Same plant left
        if (start == end) {
            if (capA >= capB) {
                if (capA < plants[start]) {
                    cntRefil++;
                }
            } else {
                if (capB < plants[start]) {
                    cntRefil++;
                }
            }
        }
        return cntRefil;
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