class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0;i<m;i++){
            for(int j = 0;j<n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i, j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int dist = 1;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] current = q.poll();
                for(int[] dir: dirs){
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] == -1){
                        matrix[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
                
            }
            dist++;
        }
        return matrix;
    }
}

//Time complexity: O(r* c)
//Space complexity: O(r* c)