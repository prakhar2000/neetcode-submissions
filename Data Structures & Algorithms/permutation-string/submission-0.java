class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] freqA = new int[26];
        int[] freqB = new int[26];
        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i = 0; i < n1; i++) {
            freqA[s1.charAt(i) - 'a']++;
            freqB[s2.charAt(i) - 'a']++;
        }

        int r = n1 - 1;
        int l = 0;
        while (r < n2) {
            if (Arrays.equals(freqA, freqB)) {
                return true;
            }
            r++;
            if (r < n2) {
                freqB[s2.charAt(r) - 'a']++;
            }
            freqB[s2.charAt(l) - 'a']--;
            l++;
        }
        return false;
    }
}
