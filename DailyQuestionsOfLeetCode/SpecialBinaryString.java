import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {
    public static String makeLargestSpecial(String s) {
        int cnt = 0, i = 0;
        List<String> list = new ArrayList<>();
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                list.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return String.join("", list);
    }

    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000"));
        System.out.println(makeLargestSpecial("10"));
    }
}
