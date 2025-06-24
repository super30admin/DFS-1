/* 
 * Brutre Force
 * Time Complexity: O(m^2 * n^2)
 * Space Complexity: O(m*n)
 */
class Solution {
    int[][] dirs;
    int m,n;
    public int[][] updateMatrix(int[][] mat) {
        this.dirs = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        this.m = mat.length;
        this.n = mat[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = bfs(mat, i, j);
                }
            }
        }
        return mat;
    }
    private int  bfs(int[][] mat, int i, int j){
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[]{i,j});
        boolean [][] visited = new boolean[m][n];
        visited[i][j] = true;
        int dist = 1;
        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            for(int k=0; k<size; k++){
                int [] curr = myQueue.poll();
                for(int[] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >=0 && c >=0 && r <m && c<n){
                        if(mat[r][c] == 0)
                            return dist;
                        else if(!visited[r][c])
                            {
                                visited[r][c] = true;
                                myQueue.add(new int[]{r,c});
                            }
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}


class Solution {
    int[][] dirs;
    int m,n;
    public int[][] updateMatrix(int[][] mat) {
        this.dirs = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        this.m = mat.length;
        this.n = mat[0].length;
        Queue<int []> myQueue = new LinkedList<>(); 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    myQueue.add(new int[]{i,j});
                }
                else{
                    mat[i][j] *= -1;
                } 
            }
        }
        int dist = 1;

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            for(int i=0; i<size; i++){
                int [] curr = myQueue.poll();
                for(int[] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c] == -1){
                        myQueue.add(new int[]{r,c});
                        mat[r][c]= dist;
                    }
                }
            }
            dist++;
        }
    return mat;
    }
}

