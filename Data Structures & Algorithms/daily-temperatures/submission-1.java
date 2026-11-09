class Solution {
    
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st= new Stack<>();

        int[] ans= new int[temperatures.length];
        Arrays.fill(ans,0);

        for(int i=temperatures.length-1; i>=0;i--){
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }

            ans[i]= st.isEmpty()?0: st.peek()-i;

            st.push(i);

        }
        return ans;
        
    }
}
