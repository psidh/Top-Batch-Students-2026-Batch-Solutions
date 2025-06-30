import java.util.*;

public class KMP {
    public List<Integer> search(String pat, String txt) {
        List<Integer> list = new ArrayList<>();
        String s = pat + '$' + txt;

        int[] arr = optimalLPS(s);

        int n = txt.length();
        int m = pat.length();

        for (int i = m + 1; i < s.length(); i++) {
            if (arr[i] == m) {
                list.add(i - 2 * m);
            }
        }
        return list;
    }

    private int[] computeLPS(String s) {
        int n = s.length();

        int[] arr = new int[n];

        for (int i = 1; i < n; i++) {
            for (int len = 1; len < i; len++) {
                if (s.substring(0, len).equals(s.substring(i - len + 1, i + 1))) {
                    arr[i] = len;
                }
            }
        }
        return arr;
    }

    private int[] optimalLPS(String s) {
        int j = 0;

        int n = s.length();
        int[] arr = new int[n];
        arr[0] = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(j)) {

                arr[i] = j + 1;
                j++;

            } else {

                while (s.charAt(i) != s.charAt(j) && j > 0) {
                    j = arr[j - 1];
                }

                if (s.charAt(i) == s.charAt(j)) {
                    arr[i] = j + 1;
                    j++;
                }
            }
        }
        return arr;
    }
}
