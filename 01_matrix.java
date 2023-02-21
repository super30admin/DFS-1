//Time complexity : O(mxn)
//Space Complexity : O(mxn) for the queues
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer> rows = new LinkedList<>() ; 
        Queue<Integer> cols = new LinkedList<>() ; 

        int dirs[][] ; 
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}} ; 

        int row = mat.length ; 
        int col = mat[0].length ; 

        for(int i = 0 ; i  < row ; i ++){
            for(int j = 0 ; j < col ; j++){
                if(mat[i][j] == 0){
                    rows.add(i) ;
                    cols.add(j) ;  
                }
            }
        }

        for(int i = 0 ; i  < row ; i ++){
            for(int j = 0 ; j < col ; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = -1 ;  
                }
            }
        }
        int level = 1 ;

        while(!rows.isEmpty()){
            int size = cols.size() ; 

            for(int j = 0 ; j < size ; j ++){
                int nrow  = rows.poll() ; 
                int ncol = cols.poll() ; 

                for(int i[]:dirs){
                    int nr = nrow + i[0] ; 
                    int nc = ncol + i[1] ; 

                    if(nr >= 0 && nr < row && nc >= 0 && nc < col && mat[nr][nc] == -1){
                        mat[nr][nc] = level;
                        rows.add(nr) ; 
                        cols.add(nc) ; 
                }
            }
            
            }
            level ++ ; 
        } 
        return mat ; 

    }
}
