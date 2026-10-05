class Solution {
    public int[] productExceptSelf(int[] nums) {
        // division approach
        //  int product = 1;
        //  int zerocount = 0;
        //  //// -1, 0, 1, 2, 3

        // /// prefix = -1, 0, 0, 0, 0
        // /// suffix =
        // for (int num : nums) {
        //     if (num == 0)
        //         zerocount++;
        //     else
        //         product = product * num;
        // }

        // int[] arr = new int[nums.length];
        // if (zerocount > 1)
        //     return arr;

        // if (zerocount == 1) {
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] == 0) {
        //             arr[i] = product;
        //         }
        //     }
        //     return arr;
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     arr[i] = product / nums[i];
        // }

        // return arr;

        // without division 
        //Use prefix and suffix array .
        //can create 2 different prefix and suffix array too and multiple the ements at the position(i), but to elimniate the space, we caluclate dthe inspace
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= suffix;
            suffix *= nums[i];
        }
        return arr;
    }
}
