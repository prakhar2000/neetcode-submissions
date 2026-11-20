class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        helper(visited, nums, ans, new ArrayList<>());

        return ans;
    }
    public void helper(
        boolean[] visited, int[] nums, List<List<Integer>> ans, ArrayList<Integer> current) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            current.add(nums[i]);
            helper(visited, nums, ans, current);

            current.remove(current.size() - 1);
            visited[i] = false;
        }

    }
}
