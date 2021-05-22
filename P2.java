//start with zeroes, modify the immediate neighbours with +1, keep doing that to next next levels
//time- o(m*n)
//space- o(m*n)


class Solution {
    public int[][] updateMatrix(int[][] mat) {
       
        if(mat==null || mat.length==0 || mat[0].length==0) return mat;
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(mat[i][j] == 0)
                {
                    q.add(new int[] {i,j}); //add the indices of zeros into the queue, to start with
                }
                else{
                    mat[i][j] = -1; // doing this, so we dont confuse the cells with distance 1 to actual value 1
                }
            }
        }
        
        int[][] dirs = {{0,1} , {1,0} , {-1,0} , {0,-1}};
        
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            
            for(int[] dir : dirs)
            {   //find neighbouring ele to current ele
                int r= curr[0] + dir[0];
                int c= curr[1] + dir[1];
                
                if(r>=0 && c>=0 && r<rows && c<cols && mat[r][c] ==-1){ //check bounds and if =-1
                    mat[r][c] = mat[curr[0]][curr[1]] + 1; //add 1 to the distance of nearest modified element
                    q.add(new int[] {r,c});
                }
            }
        }
        
        return mat;
    }
}