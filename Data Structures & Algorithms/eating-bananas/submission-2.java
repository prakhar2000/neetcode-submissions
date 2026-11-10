class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int k=1;
        // int preSum=h+1;

        // while(preSum>h){
        //     int sum=0;
        //     for(int p:piles){
        //         sum= sum+ (int) Math.ceil((double) p / k);;

        //     }
        //     k++;
        //     preSum=sum;

        // }
        // return k-1;

        int maxPile = 0;
        for (int p : piles) {
            maxPile = Math.max(maxPile, p);
        }

        int l = 1;
        int r = maxPile;
        int ans = maxPile;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;

            int totalh = 0;
            for (int p : piles) {
                totalh += (p + mid - 1) / mid;
            }

            if (totalh <= h) {
                ans = mid;
                r = mid - 1;

            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
