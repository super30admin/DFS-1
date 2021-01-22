// Time Complexity : 0(m*n)
// Space Complexity : 0(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had little difficulty in thinking how to update distance

class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null)
            return matrix;

        int m = matrix.length;
        int n = matrix[0].length;

        //for bfs
        Queue<int[]> q = new LinkedList<>();

        //substituting all 1s with -1 so that the dist is not confusing
        for(int i = 0;i < m; i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 1)
                    matrix[i][j] = -1;
                else
                    q.offer(new int[]{i,j});
            }
        }

        int dist = 0;

        //iterating through pairs in the queue
        while(!q.isEmpty()){
            int size = q.size();
            dist++; //increasing dist based on next level reached

            //iterating through elements in that level and going in all 4 directions
            for(int i=0;i<size;i++){
                int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    //if element is -1, then updating dist & adding to queue
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                        matrix[r][c] = dist;
                        q.offer(new int[]{r,c});
                    }
                }
            }
        }

        return matrix;
    }
}