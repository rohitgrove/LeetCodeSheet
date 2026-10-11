public class BusBooking {
    private boolean[][] booked;
    private int[][] cost;
    private int totalTime;
    private int bookedCount;

    public BusBooking(int n) {
        booked = new boolean[n + 1][4];
        cost = new int[n + 1][4];
        totalTime = 0;
        bookedCount = 0;
    }

    public void toggle(String seat) {
        char ch = seat.charAt(0);
        int row = Integer.parseInt(seat.substring(1));
        int col = ch - 'A';

        if (booked[row][col]) {
            totalTime -= cost[row][col];
            booked[row][col] = false;
            cost[row][col] = 0;
            bookedCount--;
            return;
        }

        int time = 1;

        if (ch == 'A' && booked[row][1]) {
            time = 3;
        } else if (ch == 'D' && booked[row][2]) {
            time = 3;
        }

        booked[row][col] = true;
        cost[row][col] = time;
        totalTime += time;
        bookedCount++;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getMinTime() {
        return bookedCount;
    }
}
