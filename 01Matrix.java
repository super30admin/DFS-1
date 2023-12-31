//Time complexity: O(m*n)
//Space Complexity:O(m*n)
//BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new LinkedList<>();

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) q.add(new int[]{i,j});
                else mat[i][j] = -1;
            }
        }
        int distance = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] current = q.poll();
                for(int[] dir : dirs){
                    int row = current[0]+dir[0];
                    int col = current[1]+dir[1];

                    if(row>=0 && col >=0 && row<m && col <n && mat[row][col] == -1){
                        mat[row][col] = distance;
                        q.add(new int[]{row,col});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}

//2.
//Time complexity: O(m*n)
//Space Complexity:O(m*n)
//DFS
class Solution {
    int result[][],m,n;
    public int[][] updateMatrix(int[][] mat) {
         this.m = mat.length;
        this. n = mat[0].length;
        result = new int[m][n];

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1)
                    result[i][j] = dfs(mat, i, j);
            }
        }
       return result;
    }
    private int dfs(int mat[][], int i, int j){
        //immediate 4 cells, base case
        if(i>0 && mat[i-1][j] == 0) return 1;
        if(j>0 && mat[i][j-1] == 0) return 1;
        if(i<m-1 && mat[i+1][j] == 0) return 1;
        if(j<n-1 && mat[i][j+1] == 0) return 1;

        //marker max val
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