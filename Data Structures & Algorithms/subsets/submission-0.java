class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);

        return ans;
        
    }

    public void helper(int index , int[] nums, List<Integer> current, List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        helper(index+1, nums, current, ans);
        current.remove(current.size()-1);
        helper(index+1, nums, current, ans);
    }
}
