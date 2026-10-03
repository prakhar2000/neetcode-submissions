class Solution {
    public boolean isAnagram(String s, String t) {

        //O(nlogn + mlogm) solution
//         char[] charArrayA = s.toCharArray();
//         char[] charArrayB= t.toCharArray();

//         Arrays.sort(charArrayA);
        
//         Arrays.sort(charArrayB);
//         if (new String(charArrayA).equals(new String(charArrayB))){
// return true;
//         }else{
// return false;
//         }

if(s.length() != t.length())return false;

int[] freqArray= new int[26];

for(int i=0;i< s.length();i++){
    freqArray[s.charAt(i)-'a']++;
    freqArray[t.charAt(i)-'a']--;
}

for(int i=0;i< freqArray.length;i++){
    if(freqArray[i]!=0)return false;
}
return true;



    }
}
