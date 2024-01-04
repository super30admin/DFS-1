// Time Complexity : O(rows * cols)
// Space Complexity : O(rows * cols)
// Method used : BFS

class Solution {

    class Pair
    {
        int row, col, count;

        Pair(int row, int col, int count)
        {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        
        int rows = mat.length, cols = mat[0].length;

        int[][] visited = new int[rows][cols];
        int[][] result = new int[rows][cols];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Pair> q = new LinkedList();

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(mat[i][j] == 0)
                {
                    visited[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                } 
            }
        }

        while(!q.isEmpty())
        {
            Pair p = q.poll();

            result[p.row][p.col] = p.count;

            for(int[] dir : dirs)
            {
                int new_row = p.row + dir[0];
                int new_col = p.col + dir[1];

                if(new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols && visited[new_row][new_col] == 0)
                {
                    visited[new_row][new_col] = 1;
                    q.add(new Pair(new_row, new_col, p.count + 1));
                }
            }
        }

        return result;
    }
}