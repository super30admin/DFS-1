//Time Complexity: O(M * N) where M is the number of rows and N is the number of columns
//Space Complexity: O(M * N)

//Successfully runs on leetcode: 14 ms

//Approach: Here, we are using BFS traversal along with size variable to keep a track of levels to find a distance according
//to the level i.e. level 1 1's will have a distance of 1 from nearest 0 and level 2 will have a distance of 2. 



class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //edge
        if(matrix == null || matrix.length == 0) return matrix;
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length; int n = matrix[0].length;
        int[][] dirs = {{0,1} , {0,-1}, {1,0}, {-1,0}};
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    queue.add(new int[]{i,j});
                }
                else
                {
                    matrix[i][j] = -1;
                }
            }
        }
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int[] curr = queue.poll();
                for(int[] dir: dirs)
                {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1)
                    {
                        matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                        queue.add(new int[] {r,c});
                    }
                }
            }
        }
        return matrix;
    }
}