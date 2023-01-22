// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//In this approach we first mark all the 1 as -1. Then we add all the 0 in the queue. Then we process each 0 by adding the neighbors in the queue
//and find where the nearest 1 is, then we change the value of the 1 to the distance at that level.
//we increase the distance once all the neighbors are done 
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)return mat;
        int m = mat.length;
        int n = mat[0].length;
        int [][] dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                   q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int distance = 1;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int []curr = q.poll();
                for(int []dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr>= 0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == -1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc] = distance;
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}
