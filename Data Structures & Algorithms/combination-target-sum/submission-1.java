class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

Arrays.sort(nums);
        helper(0, nums, ans, new ArrayList<>(), target);

        return ans;
    }

    public void helper(
        int index, int[] nums, List<List<Integer>> ans, ArrayList<Integer> current, int target) {
        
        if (target==0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (index == nums.length || nums[index]>target) {
            return;
        }
        current.add(nums[index]);
        helper(index, nums, ans, current, target-nums[index]);

        current.remove(current.size() - 1);
        helper(index + 1, nums, ans, current, target);
    }
}
