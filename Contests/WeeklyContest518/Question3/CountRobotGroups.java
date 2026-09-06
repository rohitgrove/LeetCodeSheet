public class CountRobotGroups {
    public static int countGroups(int[] position, int[] speed, int distance) {
        int groups = 1;
        int groupSpeed = speed[position.length - 1];
        int groupLeft = position[position.length - 1];

        for (int i = position.length - 2; i >= 0; i--) {
            boolean closeEnough = distance + position[i] >= groupLeft;
            boolean faster = groupSpeed < speed[i];

            if (closeEnough || faster) {
                groupLeft = position[i];
            } else {
                groups++;
                groupSpeed = speed[i];
                groupLeft = position[i];
            }
        }

        return groups;
    }

    public static void main(String[] args) {
        int[] position1 = { 1, 5, 6, 20 };
        int[] speed1 = { 4, 3, 2, 3 };

        System.out.println(countGroups(position1, speed1, 1));
        // Output: 2

        int[] position2 = { 1, 5, 9 };
        int[] speed2 = { 3, 2, 2 };

        System.out.println(countGroups(position2, speed2, 2));
        // Output: 2

        int[] position3 = { 9 };
        int[] speed3 = { 8 };

        System.out.println(countGroups(position3, speed3, 5));
        // Output: 1

        int[] position4 = { 0, 5, 10 };
        int[] speed4 = { 1, 10, 1 };

        System.out.println(countGroups(position4, speed4, 5));
        // Output: 1

        int[] position5 = { 0, 10, 20 };
        int[] speed5 = { 1, 2, 3 };

        System.out.println(countGroups(position5, speed5, 1));
        // Output: 3
    }
}
