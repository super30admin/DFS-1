class Solution {
    int [][] dirs;
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        if(matrix.length == 0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        dirs = new int [][] {{1,0},{0,1},{0,-1},{-1,0}};

        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else if (matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];

                if(nr<m && nr >=0 && nc < n && nc >=0 && matrix[nr][nc] == -1){
                    matrix[nr][nc] = matrix[r][c] + 1;
                    q.add(new int[]{nr,nc});
                }
            }


        }
        return matrix;

    }
}


/**
TC : O(m*n)
Sc : O(m*n)


Descrption : First finding the all independent nodes and  finding the distance in level by level.  TC : O(m*n).

When we are inside the queue, we are changing the number with distance, but here the problem is the first level will be 1. And the numbers inside the matrix are 1. 

So while searching for ‘0’ itself, we will change all the 1’s to -1.

Even without the size variable we can do it in this problem, bcz we are relying on the current element. If we have any neighbor then its current number + 1




 */