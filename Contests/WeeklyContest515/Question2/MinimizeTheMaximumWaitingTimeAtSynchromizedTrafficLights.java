public class MinimizeTheMaximumWaitingTimeAtSynchromizedTrafficLights {
    public static int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreenPhase = Integer.MIN_VALUE;
        for (int i = 0; i < lights.length; i++) {
            maxGreenPhase = Math.max(maxGreenPhase, lights[i]);
        }

        int penalty = 0;

        for (int i = 0; i < arrivalTime.length; i++) {
            int onTime = arrivalTime[i] % period;

            int waiting = 0;

            if (maxGreenPhase <= onTime) {
                waiting = period - onTime;
            }

            if (penalty <= waiting) {
                penalty = waiting;
            }
        }
        return penalty;
    }

    public static void main(String[] args) {
        int lights1[] = { 2, 3 }, arrivalTime1[] = { 2, 5, 8, 11 };
        System.out.println(minPenalty(8, lights1, arrivalTime1));

        int lights2[] = { 3, 6, 8 }, arrivalTime2[] = { 4, 9, 15 };
        System.out.println(minPenalty(10, lights2, arrivalTime2));

        int lights3[] = { 2 }, arrivalTime3[] = { 2, 3, 4, 5, 6 };
        System.out.println(minPenalty(5, lights3, arrivalTime3));
    }
}
