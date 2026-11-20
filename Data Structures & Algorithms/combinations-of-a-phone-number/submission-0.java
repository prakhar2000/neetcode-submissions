class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();

        return helper(digits, 0);
    }

    String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> helper(String digits, int index) {

if(index==digits.length()){
    List<String> base= new ArrayList<>();
    base.add("");
    return base;

}

        List<String> myResult = new ArrayList<String>();
        List<String> rec = helper(digits, index + 1);
        char ch = digits.charAt(index);
        String code = codes[ch - '0'];

        for (String r : rec) {
            for (int i = 0; i < code.length(); i++) {
                char chCode = code.charAt(i);
                myResult.add(chCode + r);
            }
        }

        return myResult;
    }
}
