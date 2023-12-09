// Time Complexity: O(mn)
// Space Complexity: O(mn)
// BFS Approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dirs[][] = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        Queue<int []> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int curr[] = q.poll();

                for(int dir[]: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];

                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c] == -1){
                        mat[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}


// Time Complexity: O(mn)
// Space Complexity: O(mn)
// BFS Approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dirs[][] = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        Queue<int []> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){

            int curr[] = q.poll();

            for(int dir[]: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r>=0 && c>=0 && r<m && c<n && mat[r][c] == -1){
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                    q.add(new int[]{r,c});
                }
            }
        }
        return mat;
    }
}



// Time Complexity: O(m^2 * n^2)
// Space Complexity: O(mn)
// BFS Bruteforce Approach
class Solution {

    int m;
    int n ;
    int dirs[][];
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        Queue<int []> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = bfs(mat, i,j);
                }
            }
        }

       
        return mat;
    }

    private int bfs(int[][] mat, int i, int j){
        Queue<int []> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(new int[]{i,j});
        visited[i][j] = true;
        int dist = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int k=0; k< size; k++){
                int curr[] = q.poll();
                for(int dir[]: dirs){
                    int r = dir[0]  + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && c>=0 && r<m && c<n){
                        if(mat[r][c] == 0) return dist;
                        else if(!visited[r][c]){
                            q.add(new int[]{r,c});
                            visited[r][c] = true;
                        }
                    }
                }
            }
            dist++;
        }
        return dist;
    }
}


// Time Complexity: O(mn)
// Space Complexity: O(mn)
// DFS with DP Approach
class Solution {

    int m;
    int n ;
    int dirs[][];
     int result[][];
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        result= new int[m][n];

        Queue<int []> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    result[i][j] = dfs(mat, i, j);
                }
            }
        }

       
        return result;
    }

    private int dfs(int mat[][], int i, int j){
        if(i>0 && mat[i-1][j] == 0) return 1;
        if(j>0 && mat[i][j-1] == 0) return 1;
        if(i<m-1 && mat[i+1][j] == 0) return 1;
        if(j<n-1 && mat[i][j+1] == 0) return 1;

        int top = 9999, right=9999, bottom = 9999, left =9999;

        if(i>0 && result[i-1][j] != 0){
            top = result[i-1][j];
        }

        if(j>0 && result[i][j-1] != 0){
            left = result[i][j-1];
        }

        if(j<n-1){
            if(result[i][j+1] == 0){
                result[i][j+1] = dfs(mat, i, j+1);

            }
            right = result[i][j+1];
        }

        if(i<m-1){
            if(result[i+1][j] == 0){
                result[i+1][j] = dfs(mat, i+1, j);
            }
            bottom = result[i+1][j];
        }
        
        return Math.min(top, Math.min(left, Math.min(right, bottom))) + 1;
    }

}