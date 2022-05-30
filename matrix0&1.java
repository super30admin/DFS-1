// Time Complexity : O(mn) m rows and n columns
// Space Complexity : O(max(m,n) 
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no

//traversed throught the whole matrix and used a state change technique to note the posiions of 1 with -1.
//used level order traversal and made all the -1 arounda zero as 1 in firts level and pushed them into queue.
in the second level -1 are replaced with distance+1 and so on.

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int dirs[][];
        int m=matrix.length,n=matrix[0].length;
        dirs = new int [][] {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> c =new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){    
                if(matrix[i][j]==1){
                    matrix[i][j] = -1;
                }
                else{
                    r.add(i);
                    c.add(j);
                }
            }
        }
        int dis = 1;
        while(!r.isEmpty() && !c.isEmpty()){
            int size = r.size();
            for(int i=0;i<size;i++){
                int p = r.poll();
                int q =c.poll();
                 for(int [] dir : dirs){
                     int curi = p + dir[0];
                     int curj = q + dir[1];
                     if(curi>=0 && curi<m && curj>=0 && curj<n && matrix[curi][curj]==-1){
                          matrix[curi][curj] = dis;
                          r.add(curi);
                         c.add(curj);

                     }
                 }
            }
            dis ++;
        }
        return matrix;
}
}