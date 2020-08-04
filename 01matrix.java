//time complexity O(n)
//space complexity O(1)
//APPROACH BFS

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        Queue<int []> q  = new LinkedList<>();
        int dist = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i, j});
                } else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r < m && r >= 0 && c < n && c >= 0 && matrix[r][c] == -1){
                        q.add(new int[]{r,c});
                        matrix[r][c] = dist;
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}
