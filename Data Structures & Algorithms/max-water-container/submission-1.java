class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int j=heights.length-1;
        while(i<j) {
            int ca = Math.min(heights[i], heights[j]) * (j - i);
            maxArea= Math.max(ca, maxArea);
            
            if(heights[j]>heights[i]){
                i++;
            }else{
                j--;
            }
        }

        return maxArea;
    }
}
