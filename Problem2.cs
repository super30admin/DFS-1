// Time Complexity : O(m*n)
// Space Complexity : O(m*n) for the visited matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain a visited matrix and mark those positions as true where matrix has a corresponding 0 value. I add these positions to the queue and perform BFS on it.
I visit all 4 directional neighbours and set their value to distance and mark them as visited and add them to the queue. Then for subsequent iterations, I 
increment distance by 1 and follow the same steps.
*/

public class Solution {

    public int[][] UpdateMatrix(int[][] mat) {
        int rows = mat.Length;
        int columns = mat[0].Length;
        bool[,] visited = new bool[rows,columns];
        int[][] dirs = new int[][]
        {
            new int[] {0,1},
            new int[] {0,-1},
            new int[] {1,0},
            new int[] {-1,0},
        };

        Queue<int[]> q = new();


        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.Enqueue(new int[] {i,j});
                    visited[i,j] = true;
                }
            }
        }

        int distance = 0;

        while(q.Count != 0)
        {
            int size = q.Count;
            for(int i = 0; i < size; i++)
            {
                int[] currentPos = q.Dequeue();
                mat[currentPos[0]][currentPos[1]] = distance;
                
                foreach(int[] dir in dirs)
                {
                    int nr = currentPos[0] + dir[0];
                    int nc = currentPos[1] + dir[1];

                    if(nr>=0 && nr<rows && nc>=0 && nc<columns && !visited[nr,nc])
                    {
                        visited[nr,nc] = true;
                        q.Enqueue(new int[] {nr,nc});
                    }
                    
                }
            }

            distance += 1;
        }

        return mat;
    }
}