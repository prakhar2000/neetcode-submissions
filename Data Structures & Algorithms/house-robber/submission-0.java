class Solution {
    public int rob(int[] nums) {
        
        int[] dp = new int[nums.length+1];
        int[] nums2= new int[nums.length+1];
        nums2[0]=-1;
        System.arraycopy(nums, 0, nums2, 1, nums.length);

        dp[0]=0;
        dp[1]= nums2[1];
        for(int i=2; i<nums2.length;i++)
        {
            dp[i]= Math.max(dp[i-1], dp[i-2]+ nums2[i]);
        }
        return dp[nums.length];
    }
}
