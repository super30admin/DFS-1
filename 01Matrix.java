// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : let's use bfs to find smallest distance of each 1 to a 0. First add all 0s to queue and set count variable to 0.
// Add all neighbors of 0s that are 1s. Increment count variable. Now for all those 1s, add their neighboring 1s while incrementing
// count variaable and replacing 1s with count variable at that time. Return the matrix.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer> q=new LinkedList<Integer>();
        int rows = mat.length, cols = mat[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
                else{
                    q.add(i);
                    q.add(j);
                }
            }
        }
        int count =0;
        int dirs[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int size = q.size()/2;
            for(int i=0;i<size;i++){
                int r = q.poll();
                int c = q.poll();
                mat[r][c] = count;
                for(int dir[]:dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr>=0 && nc>=0 && nr< rows && nc< cols && mat[nr][nc]==-1){
                        mat[nr][nc] = 0;
                         q.add(nr);
                        q.add(nc);
                    }
                }
            }
            count++;
        }
        return mat;
    }
}