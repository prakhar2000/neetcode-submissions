class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(0, nums, ans, new ArrayList<>());

        return ans;


    }

    public void helper(int index, int[] nums, List<List<Integer>> ans, ArrayList<Integer> current){

        ans.add(new ArrayList<>(current));

        for(int i=index; i< nums.length; i++){
            if(i> index && nums[i]==nums[i-1]){
                continue;
            }

            current.add(nums[i]);
            helper(i+1, nums, ans, current);
            current.remove(current.size()-1);
        }

    }
}
