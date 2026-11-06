class Solution {
    public int trap(int[] height) {
        // int[] prefix = new int[height.length];
        // prefix[0] = height[0];
        // int[] suffix = new int[height.length];
        // suffix[height.length - 1] = height[height.length - 1];

        // for (int i = 1; i < height.length; i++) {
        //     prefix[i] = Math.max(height[i], prefix[i - 1]);
        // }
        // for (int i = height.length - 2; i >= 0; i--) {
        //     suffix[i] = Math.max(height[i], suffix[i + 1]);
        // }

        // int water = 0;
        // for (int i = 1; i < height.length - 1; i++) {
        //     water += Math.min(prefix[i], suffix[i]) - height[i];
        // }
        // return water;


        //stack
        int h= height.length;
        if(h==0) return 0;

        Stack<Integer> s= new Stack<>();
        int water=0;
        for(int i=0;i< h;i++){
            while(!s.isEmpty() && height[i]>=height[s.peek()]){
                int mid= height[s.pop()];
                if(!s.isEmpty()){
                    int r= height[i];
                    int l= height[s.peek()];
                    int hi= Math.min(l, r)-mid;
                    int w= i-s.peek()-1;
                    water+=hi*w;
                }
            }
            s.push(i);
        }
        return water;




    }
}

// stack-> 