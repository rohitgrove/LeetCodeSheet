public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        char letters1[] = { 'c', 'f', 'j' };
        System.out.println(nextGreatestLetter(letters1, 'a'));
        System.out.println(nextGreatestLetter(letters1, 'c'));
        char letters2[] = { 'x', 'x', 'y', 'y' };
        System.out.println(nextGreatestLetter(letters2, 'z'));
        char letters3[] = { 'e', 'e', 'g', 'g' };
        System.out.println(nextGreatestLetter(letters3, 'g'));
    }
}
