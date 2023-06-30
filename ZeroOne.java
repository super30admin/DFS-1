// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; //right,down,left,top
        int m = mat.length;
        int n = mat[0].length;
        int level = 1;
        Queue<int[]> q = new LinkedList<>();
        // start iterating over the matrix and make all 1's as -1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0) q.add(new int[]{i,j});
                if(mat[i][j] == 1) mat[i][j] = -1;
            }
        }

                    while(!q.isEmpty()){
                        int size = q.size();
                        // level processing
                        for(int i =0;i<size;i++){
                            int[] temp = q.poll();
                            for(int[] dir:dirs){
                                int nr = temp[0] + dir[0];
                                int nc = temp[1] + dir[1];
                                if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc] == -1){
                                    mat[nr][nc] = level;
                                    q.add(new int[]{nr,nc});
                                }   
                                
                            }
                        
                        }
                        level++;
                    }

        return mat;


    }
}