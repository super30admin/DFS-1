//Leetcode Problem : https://leetcode.com/problems/01-matrix/description/
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I maintain rows and columns variables that store the dimensions of the matrix. I maintain a Queue of int[]. I travserse through the matrix and add coordinates if all 0s to the queue and change every other value to -1. I set distance as 1 initially and perform BFS while q is not empty.
 * I traverse from i = 0 to q size -1 and obtain the coordinates by polling the queue. I traverse through all 4 direction neighbours and if there's any neighbour with value = -1. I replace it with distance. After the inner for loop, I increment distance.
 */
class Solution {
    int [][]dirs;
    int rows;
    int columns;
    public int[][] updateMatrix(int[][] mat) {
        rows = mat.length;
        columns = mat[0].length;
        dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[] {i,j});
                }
                else
                {
                    mat[i][j]=-1;
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int []cord = q.poll();
                int r = cord[0];
                int c = cord[1];
                for(int []dir : dirs)
                {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr>=0 && nr<rows && nc>=0 && nc<columns && mat[nr][nc]==-1)
                    {
                        mat[nr][nc] = dist;
                        q.add(new int[] {nr,nc});
                    }
                }
            }
            dist++;
        }

        return mat;
    }
}