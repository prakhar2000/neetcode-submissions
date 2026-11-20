class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        helper(ans, n, new StringBuilder(""), 0);

        return ans;
    }

    public void helper(List<String> ans, int n, StringBuilder current, int c) {
        if (current.length() == 2 * n) {
            if(c!=0) return;
            ans.add(current.toString());
            return;
        }
        current.append("(");
        helper(ans, n, current, c + 1);
        current.deleteCharAt(current.length() - 1);
        if (c > 0) {
            current.append(")");
            helper(ans, n, current, c - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
