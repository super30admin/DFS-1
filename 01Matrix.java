// Time complexity: O(mxn)
// Space complexity: O(mxn)
// Run on Leetcode: Yes
// Issues faced: None

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    queue.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir: dirs){
                int x = curr[0]+dir[0];
                int y = curr[1]+dir[1];
                if(x>=0 && y>=0 && x<m && y<n && mat[x][y] == -1){
                    mat[x][y] = mat[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return mat;
    }
}
