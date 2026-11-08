class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int r = 0;
        int l = 0;
        int[] countT = new int[128];
        int[] window = new int[128];
        int have = 0;
        int need = 0;
        for (int i = 0; i < t.length(); i++) {
            countT[t.charAt(i)]++;
        }
        for (int count : countT) {
            if (count > 0) {
                need++;
            }
        }

        

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (r < s.length()) {
            char rChar = s.charAt(r);
            window[rChar]++;

            if (countT[rChar] > 0 && window[rChar] == countT[rChar]) {
                have++;
            }
            while (have == need) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    minStart = l;
                }

                char lChar = s.charAt(l);
                window[lChar]--;

                if (countT[lChar] > 0 && window[lChar] < countT[lChar]) {
                    have--;
                }

                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
