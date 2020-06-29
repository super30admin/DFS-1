// Time Complexity : O(m*n)
// Space Complexity :O (m*n)

<-----DFS---->
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
		if (matrix.length == 0)
			return matrix;

        // Initialize, only 1 who neighbors 0 is determined. Kind of path trimming.
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 1 && !hasNeiberZero(i, j, matrix))
					matrix[i][j] = matrix.length + matrix[0].length + 1;

        // Start from the determined 1
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 1)
					dfs(matrix, i, j, 1);

		return matrix;
	}

	private void dfs(int[][] matrix, int x, int y, int val) {
        // Base case. Boundary condition and new value who is larger than the previous found value, terminates.
		if (x < 0 || y < 0 || y >= matrix[0].length || x >= matrix.length || (matrix[x][y] < val)) {
			return;
		}

        // Set it as new value
		matrix[x][y] = val;

		dfs(matrix, x + 1, y, matrix[x][y] + 1);
		dfs(matrix, x - 1, y, matrix[x][y] + 1);
		dfs(matrix, x, y + 1, matrix[x][y] + 1);
		dfs(matrix, x, y - 1, matrix[x][y] + 1);
	}

	private boolean hasNeiberZero(int x, int y, int[][] matrix) {
		if (x - 1 >= 0 && matrix[x - 1][y] == 0)
			return true;
		if (x + 1 < matrix.length && matrix[x + 1][y] == 0)
			return true;
		if (y - 1 >= 0 && matrix[x][y - 1] == 0)
			return true;
		if (y + 1 < matrix[0].length && matrix[x][y + 1] == 0)
			return true;

		return false;
	}
}

<-----BFS---->
class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        if(matrix == null || matrix.length == 0) return matrix;

        Queue<int[]> q = new LinkedList<>();


        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    q.add(new int [] {i, j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){

            int [] cur = q.poll();
            for(int[] dir: dirs){
                int r = cur[0]+dir[0];
                int c = cur[1]+dir[1];

                if(r>=0 && r<matrix.length && c>=0 && c<matrix[0].length && matrix[r][c] == -1){
                    matrix[r][c] = matrix[cur[0]][cur[1]]+1;
                    q.add(new int[]{r,c});
                }
            }
        }

        return matrix;

    }
}

<----DP---->
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //edge
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[m][n];
        
        for (int[] row : ans)       
            Arrays.fill(row, m + n);                

        // top-left to bottom-right         
        for (int r = 0; r < m; r++) {       
            for (int c = 0; c < n; c++) {                   
                if (matrix[r][c] == 0) ans[r][c] = 0;                                              
                else {
                    if (r > 0) ans[r][c] = Math.min(ans[r][c], 1 + ans[r - 1][c]);
                    if (c > 0) ans[r][c] = Math.min(ans[r][c], 1 + ans[r][c - 1]);
                }
            }                           
        }

        // bottom-right to top-left
        for (int r = m - 1; r >= 0; r--) {                                          
            for (int c = n - 1; c >= 0; c--) {              
                if (matrix[r][c] == 0) ans[r][c] = 0;
                else {
                    if (r < m - 1) ans[r][c] = Math.min(ans[r][c], 1 + ans[r + 1][c]); 
                    if (c < n - 1) ans[r][c] = Math.min(ans[r][c], 1 + ans[r][c + 1]);
                }                                                   
            }
        }                                       
        return ans;
    }
}