// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[] dx = {0,-1,0,1}; //directions
        int[] dy = {-1,0,1,0};

        int R = matrix.length;
        int C = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j]==0)
                    queue.add(new int[]{i,j});
                else if(matrix[i][j]==1)
                    matrix[i][j]=-1; //assign identifier
            }
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for(int i=0;i<4;i++){ //check directions
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr>=0 && nc>=0 && nr<R && nc<C && matrix[nr][nc]==-1){
                    matrix[nr][nc] = matrix[r][c]+1;
                    queue.add(new int[]{nr,nc}); //add new 1's with distance
                }
            }
        }

        return matrix;
    }
}