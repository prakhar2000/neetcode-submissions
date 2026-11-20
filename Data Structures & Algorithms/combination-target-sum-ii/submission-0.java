class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, ans, new ArrayList<>(), target);
        return ans;
        
    }

    private void helper(int index, int[] candidates, List<List<Integer>> ans, List<Integer> current, int target) {

        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(index==candidates.length || candidates[index]> target){
            return;
        }

        current.add(candidates[index]);
        helper(index+1, candidates, ans, current, target-candidates[index]);
        current.remove(current.size()-1);

        while(index+1<candidates.length && candidates[index] == candidates[index + 1]){
            index++;
        }
helper(index + 1, candidates, ans, current, target);

    }
}
