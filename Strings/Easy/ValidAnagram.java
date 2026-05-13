import java.util.Arrays;

public class ValidAnagram {
    public static boolean bruteForce(String s, String t) {
        char sCharArray[] = s.toCharArray();
        char tCharArray[] = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        s = Arrays.toString(sCharArray);
        t = Arrays.toString(tCharArray);

        return s.equals(t);
    }

    public static boolean optimizedApproach(String s, String t) {
        char hash[] = new char[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String s, String t) {
        return optimizedApproach(s, t);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
