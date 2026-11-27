class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> l = new ArrayList<>();

        for(int i=0 ; i < numCourses; i++){
            l.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            int from= edge[1]; 
            int to=edge[0];
            l.get(from).add(to);
        }

        boolean[] vis= new boolean[numCourses];
        boolean[] recPath= new boolean[numCourses];
        Stack<Integer> st= new Stack<>();

        for(int i=0; i< numCourses; i++){
            if(!vis[i]){
                if(dfs(l, i, vis, recPath, st))
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        Arrays.setAll(ans, i -> st.pop());
        // for (int i = 0; i < numCourses; i++) {
        //     ans[i] = st.pop();
        // }


        return ans;
    }


    public boolean dfs(List<List<Integer>> l, int src,boolean[] vis, boolean[] recPath, Stack<Integer> st ){

        vis[src]= true;
        recPath[src]= true;


        for(int v: l.get(src)){
            if(!vis[v]){
                if(dfs(l, v, vis, recPath, st)){
                    return true;
                }
            }else if(recPath[v]){
            
                return true;
            }
        }

        recPath[src]= false;
        st.push(src);
        return false;

    }
}
