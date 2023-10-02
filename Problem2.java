// Time Complexity : O(m x n) where m is the number of rows and n is the number of columns
// Space Complexity : O(m x n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public int[][] updateMatrix(int[][] mat) {

        if(mat == null || mat.length == 0){
            return mat;
        }

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i, j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }


        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                    q.add(new int[] {nr, nc});
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                }
            }
        }

        return mat;
    }
}
