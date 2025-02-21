// Problem2 (https://leetcode.com/problems/01-matrix/)

// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, the places with all the zeroes are added to the queue first and 1's are converted to -1's to keep track of visited.
 * while q is not empty, for each loop of size q, get the element out of q and find new row and new col and if the element at
 * new row and new col is -1 then make it to dist and keep that in queue and increase dist after each loop. Finally return
 * matrix.
 */

 class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int []> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int [][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int []prev = q.poll();
                int currow = prev[0];
                int curcol = prev[1];
                for(int[] dir: dirs){
                    int newrow = currow+dir[0];
                    int newcol = curcol+dir[1];
                    if(newrow>=0 && newrow<m && newcol>=0 && newcol<n && mat[newrow][newcol]==-1){
                        q.add(new int[]{newrow,newcol});
                        mat[newrow][newcol] = dist;
                    }
                 }
            }
            dist++;
        }
        return mat;
    }
}