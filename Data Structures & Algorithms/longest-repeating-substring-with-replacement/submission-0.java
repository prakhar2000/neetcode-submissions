class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int[] count= new int[26];

        int maxL=0;
        int maxF=0;

        while(r<s.length()){
            count[s.charAt(r)-'A']++;
            maxF= Math.max(maxF, count[s.charAt(r)-'A']);

            while((r-l+1)-maxF > k){
                count[s.charAt(l)-'A']--;
                l++;
            }
            maxL= Math.max(maxL, r-l+1);
            r++;
        }
        return maxL;
    }
}
