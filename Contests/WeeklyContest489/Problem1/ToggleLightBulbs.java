import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToggleLightBulbs {
    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] lights = new boolean[101];

        for (int bulb : bulbs) {
            lights[bulb] = !lights[bulb];
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            if (lights[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(10, 30, 20, 10);
        System.out.println(toggleLightBulbs(test1));

        List<Integer> test2 = Arrays.asList(100, 100);
        System.out.println(toggleLightBulbs(test2));
    }
}
