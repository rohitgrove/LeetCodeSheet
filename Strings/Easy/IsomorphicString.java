public class IsomorphicString {
    public static String updateMappingString(StringBuilder str) {
        char hash[] = new char[256];
        char start = 'a';

        for (int i = 0; i < str.length(); i++) {
            if (hash[str.charAt(i)] == 0) {
                hash[str.charAt(i)] = start;
                start++;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            str.setCharAt(i, hash[str.charAt(i)]);
        }

        return str.toString();
    }

    public static boolean isIsomorphic(String s, String t) {
        StringBuilder sstr = new StringBuilder(s);
        StringBuilder tstr = new StringBuilder(t);

        updateMappingString(sstr);
        updateMappingString(tstr);

        s = updateMappingString(sstr);
        t = updateMappingString(tstr);

        return s.equals(t);
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("f11", "b23"));
        System.out.println(isIsomorphic("paper", "title"));
    }
}
