class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, ans, new ArrayList<>(), 0);

        return ans;
    }
    public boolean IsPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public void helper(String s, List<List<String>> ans, List<String> current, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (IsPalindrome(s, index, i)) {
                current.add(s.substring(index, i+1));
                helper(s, ans, current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
