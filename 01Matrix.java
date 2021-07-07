// Time Complexity : O(m * n)
// Space Complexity : O(m * n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat[0].length == 0)
            return mat;
        int m = mat.length;
        int n = mat[0].length;
        int dist = 1;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i = 0; i < size;i++){
                int cur[] = q.poll();
                for(int[] dir:dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1){
                        q.add(new int[]{r,c});
                        mat[r][c] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}