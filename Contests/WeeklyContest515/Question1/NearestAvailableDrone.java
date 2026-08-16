public class NearestAvailableDrone {
    public static int nearestDrone(int[][] drones, int[] target) {
        int minDist = Integer.MAX_VALUE;
        int ans = -1;

        int idx = 0;
        while (idx < drones.length) {
            int droneDist1 = drones[idx][0];
            int droneDist2 = drones[idx][1];
            int droneRange = drones[idx][2];

            int currDist = Math.abs(droneDist1 - target[0]) + Math.abs(droneDist2 - target[1]);

            if (currDist <= droneRange) {
                if (currDist < minDist) {
                    minDist = currDist;
                    ans = idx;
                }
            }

            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int drones1[][] = { { 0, 0, 8 }, { 2, 2, 9 } },
                target1[] = { 3, 4 };
        System.out.println(nearestDrone(drones1, target1));
        int drones2[][] = { { 2, 1, 5 }, { 4, 4, 5 }, { 6, 6, 8 } },
                target2[] = { 5, 5 };
        System.out.println(nearestDrone(drones2, target2));
        int drones3[][] = { { 4, 4, 5 } },
                target3[] = { 8, 6 };
        System.out.println(nearestDrone(drones3, target3));
    }
}
