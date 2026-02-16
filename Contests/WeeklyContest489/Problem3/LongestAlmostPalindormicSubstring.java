public class LongestAlmostPalindormicSubstring {
    public static int almostPalindromic(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length, ans = 0;

        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                l--;
                r++;
            }
            int len = r - l - 1;

            if (l < 0 || r >= n)
                ans = Math.max(ans, len + (l >= 0 || r < n ? 1 : 0));
            else {
                int x = 0, y = 0, j = l - 1, k = r;
                while (j >= 0 && k < n && arr[j] == arr[k]) {
                    x += 2;
                    j--;
                    k++;
                }
                j = l;
                k = r + 1;
                while (j >= 0 && k < n && arr[j] == arr[k]) {
                    y += 2;
                    j--;
                    k++;
                }
                ans = Math.max(ans, len + 1 + Math.max(x, y));
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                l--;
                r++;
            }
            len = r - l - 1;

            if (l < 0 || r >= n)
                ans = Math.max(ans, len + (l >= 0 || r < n ? 1 : 0));
            else {
                int x = 0, y = 0, j = l - 1, k = r;
                while (j >= 0 && k < n && arr[j] == arr[k]) {
                    x += 2;
                    j--;
                    k++;
                }
                j = l;
                k = r + 1;
                while (j >= 0 && k < n && arr[j] == arr[k]) {
                    y += 2;
                    j--;
                    k++;
                }
                ans = Math.max(ans, len + 1 + Math.max(x, y));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(almostPalindromic("abca"));
        System.out.println(almostPalindromic("abba"));
        System.out.println(almostPalindromic("zzabba"));
    }
}
