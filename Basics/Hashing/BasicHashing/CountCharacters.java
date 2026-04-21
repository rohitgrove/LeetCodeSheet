public class CountCharacters {
    public static void countLowerCharacter(String str) {
        int hash[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                char ch = (char) ('a' + i);
                System.out.println(ch + " " + hash[i]);
            }
        }
    }

    public static void countUpperCharacter(String str) {
        int hash[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'A']++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                char ch = (char) ('A' + i);
                System.out.println(ch + " " + hash[i]);
            }
        }
    }

    public static void main(String[] args) {
        countLowerCharacter("ajidjoinienrfggrom");
        countUpperCharacter("ASKNKNFIKRNINVIN");
    }
}
