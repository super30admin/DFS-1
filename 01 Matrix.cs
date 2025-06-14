/*
  Time complexity: O(m*n)
  Space complexity: O(m*n)

  Code ran successfully on Leetcode: Yes

*/

public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        Queue<(int row, int col)> queue = new();
        int[][] dirs = {new int[2]{-1,0},new int[2]{1,0},new int[2]{0,-1},new int[2]{0,1}};

        for(int i=0;i<mat.Length;i++)
        {
            for(int j=0;j<mat[0].Length;j++)
            {
                if(mat[i][j]==0)
                    queue.Enqueue((i,j));
                else
                    mat[i][j]=-1;
            }
        }

        while(queue.Count>0)
        {
            var temp = queue.Dequeue();
            foreach(var d in dirs)
            {
                int nr = d[0]+temp.row;
                int nc = d[1]+temp.col;

                if(nr>=0 && nr<mat.Length && nc>=0 && nc<mat[0].Length && mat[nr][nc]==-1)
                {
                    mat[nr][nc] = mat[temp.row][temp.col]+1;
                    queue.Enqueue((nr,nc));
                }
            }

        }
        return mat;

    }
}
