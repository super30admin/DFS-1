// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class MatrixUpdate {
    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int []> q = new LinkedList<>();
        //change each 1 to -1 to signify not visited
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }else{
                    q.add(new int[]{i,j});
                }
            }
        }

        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int dist = 1;
        //BFS
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    //find adjacent coordinate
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    //if not visited
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                        q.add(new int[]{r,c});
                        //set distance as new state
                        matrix[r][c] = dist;
                    }
                }
            }
            //inc distance every iteration
            dist++;
        }
        return matrix;
    }
}