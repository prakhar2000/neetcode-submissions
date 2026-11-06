class Solution {
    public int maxProfit(int[] prices) {
        int[] prefix= new int[prices.length];
        prefix[prices.length-1]= prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            prefix[i]= Math.max(prefix[i+1], prices[i]);
        }

int maxProfit=0;
        for(int i=0;i< prices.length;i++){
            int trade= prefix[i]- prices[i];
            if(trade<0)continue;
            maxProfit= Math.max(maxProfit,trade);

        }
        return maxProfit;
    }
}
