import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);

                if (totalBits == turnedOn) {
                    String time = hour + ":" + (minute < 10 ? "0" + minute : minute);
                    result.add(time);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
        System.out.println(readBinaryWatch(9));
    }
}
