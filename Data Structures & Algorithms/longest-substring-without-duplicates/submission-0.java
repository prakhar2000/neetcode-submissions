class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        HashSet<Character> hs= new HashSet<>();
        int maxLen=0;
        int currLen=0;

        while(l<=r && r< s.length()){
            Character temp=s.charAt(r);
            if(!hs.contains(temp)){
                hs.add(temp);
                r++;
                currLen++;
            }else{
                hs.remove(s.charAt(l));
                l++;
                currLen--;

            }
            maxLen= Math.max(maxLen, currLen);


        }
        return maxLen;
    }
}
