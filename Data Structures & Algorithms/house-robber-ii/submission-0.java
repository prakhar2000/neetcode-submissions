class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Run 1: houses 0 .. n-2 (skip the last house)
        // dp[i] = best using the first i houses
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n - 1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        // Run 2: houses 1 .. n-1 (skip the first house)
        // dp2[i] = best using houses 1 .. i-1
        int[] dp2 = new int[n + 1];
        dp2[0] = 0;
        dp2[1] = 0;            // house 0 is skipped
        for (int i = 2; i <= n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i-1]);
        }

        return Math.max(dp[n - 1], dp2[n]);
    }
}