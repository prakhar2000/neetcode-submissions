class Solution {
    public int helper(int[] nums, int lo, int hi) {
        if (lo == hi)
            return nums[lo];

        int mid = (hi + lo) / 2;
        int left = helper(nums, lo, mid);
        int right = helper(nums, mid + 1, hi);

int size= hi-lo+1;
        if (left == right)
            return left;
        if (left != -1 && count(nums, lo, hi, left) > size / 2)
            return left;

        if (right != -1 && count(nums, lo, hi, right) > size / 2)
            return right;

        return -1;
    }

    private int count(int[] nums, int lo, int hi, int tocount) {
        int c = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == tocount)
                c++;
        }
        return c;
    }

    public int majorityElement(int[] nums) {
        // using hashmap - space o(n)

        // usieng divide nad conquer - space o(1)

        return helper(nums, 0, nums.length - 1);
    }
}