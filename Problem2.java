// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length ==0){
            return matrix;
        }

        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n=matrix[0].length;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[] {i,j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0; i<size;i++){
                int[] pos = queue.poll();

                for(int[] dir : dirs){
                    int r = pos[0] + dir[0];
                    int c = pos[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] > matrix[pos[0]][pos[1]] +1){
                        matrix[r][c] =  matrix[pos[0]][pos[1]] + 1;
                        queue.add(new int[] {r,c});
                    }
                }
            }

        }
        return matrix;
    }
}