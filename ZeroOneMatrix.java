//TC: O(m*n) where m is the number of rows, n is the number of columns
//SC: O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class ZeroOneMatrix {
}
//MEthod 2 - BFS without size variable
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return matrix;

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = new int [][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }

                else{
                    matrix[i][j] = -1;
                }
            }
        }

        int dist = 0;
        while(!q.isEmpty()){

            int[] curr = q.poll();

            for(int[] dir: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];

                //bound check
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1){
                    matrix[nr][nc] = matrix[curr[0]][curr[1]]+ 1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return matrix;
    }
}

//Method 1 -  BFS using size variable
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return matrix;

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = new int [][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }

                else{
                    matrix[i][j] = -1;
                }
            }
        }

        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size ; i++){
                int[] curr = q.poll();

                for(int[] dir: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    //bound check
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1){
                        matrix[nr][nc] = dist + 1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}