// Time Complexity : O(m*n)
// Space Complexity : O(m*n) - new matrix and queue too
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Start with all 0's cell. Proceed level by level (immediate neighbours and update count based on level)

//This is BFS solution.

//Optimal - O(m*n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        if(mat == null || mat.length ==0) return mat;

        int m = mat.length;
        int n = mat[0].length;
        Queue<int []> q = new LinkedList<>();

        int[][] dirs = {{1,0}, {0,-1}, {-1,0}, {0,1}}; //4 directions clockwise

        for(int i =0; i<m ;i++){
            for(int j=0; j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j}); // level-0
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        
        int level = 0;
        int size = 0;
        while(!q.isEmpty()){
            //Process level by level
            size = q.size();
            level++; //Before processing each level increment its count. This is for distance
            while(size>0){
                int[] curr = q.poll();

                //find neighbours
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    //bounds check
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                        mat[nr][nc] = level;
                        q.add(new int[]{nr,nc});
                    }
                }
                size--;
            }
        }
        return mat;
    }
}