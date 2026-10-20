class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> hmr = new HashMap<>();
        HashMap<Integer, HashSet<Character>> hmc = new HashMap<>();
        HashMap<Integer, HashSet<Character>> hmb = new HashMap<>();


        for(int i=0;i< board.length;i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                //for row
                if(hmr.containsKey(i)){
                    HashSet<Character> temp= hmr.get(i);
                    if(temp.contains(board[i][j]))return false;
                    else{
                        temp.add(board[i][j]);
                        hmr.put(i, temp);
                    }
                }else{
                    hmr.put(i, new HashSet<Character>(Arrays.asList(board[i][j])));
                }
            

                //for col
                if(hmc.containsKey(j)){
                    HashSet<Character> temp= hmc.get(j);
                    if(temp.contains(board[i][j]))return false;
                    else{
                        temp.add(board[i][j]);
                        hmc.put(j, temp);
                    }
                    
                }else{
                    hmc.put(j, new HashSet<Character>(Arrays.asList(board[i][j])));

                }


                //for sq
                int key = 3*(i/3)+ j/3;
                if(hmb.containsKey(key)){
                    HashSet<Character> temp= hmb.get(key);
                    if(temp.contains(board[i][j]))return false;
                    else{
                        temp.add(board[i][j]);
                        hmb.put(key, temp);
                    }

                }else
                {
                    hmb.put(key, new HashSet<Character>(Arrays.asList(board[i][j])));
                }




            }
        }
        

        return true;
        
    }
}
