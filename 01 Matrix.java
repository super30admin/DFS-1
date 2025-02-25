class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;

        int[][] distance = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 0){
                    distance[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
                else{
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] directions = {-1,0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for(int j = 0; j < 4; j++){
                int nx = x + directions[j];
                int ny = y + directions[j+1];

                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && distance[nx][ny] > distance[x][y] + 1){
                    distance[nx][ny] = distance[x][y] + 1 ;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return distance; 
    }
}
// Time Complexity: O(M * N) -> Each cell is processed at most once in BFS.
// Space Complexity: O(M * N) -> Queue stores at most all cells in the worst case.
