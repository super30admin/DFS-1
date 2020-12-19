public class Solution {
int rows=0;
int cols =0;
​
    public static (int, int)[] directions = { (0, 1), (0, -1), (1, 0), (-1, 0) };
    public int[][] UpdateMatrix(int[][] matrix) {
        if(matrix==null || matrix.Length==0)
        {
            return matrix;
        }
        
        rows = matrix.Length;
        cols = matrix[0].Length;
        
        Queue<int[]> q = new Queue<int[]>();
        int dist =1;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(matrix[i][j]==0)
                {
                    q.Enqueue(new int[]{i,j});
                }
                else
                {
                    matrix[i][j]=-1;
                }
            }
        }
        
        while(q.Count>0)
        {
            int size = q.Count;
            for(int k=0;k<size;k++)
            {
                int[] curr = q.Dequeue();
                foreach(var dir in directions)
                {
                    int r = curr[0] + dir.Item1;
                    int c = curr[1] + dir.Item2;
                    if(r>=0 && r<rows && c>=0 && c< cols && matrix[r][c]==-1)
                    {
                        matrix[r][c] = dist;
                        q.Enqueue(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
​
}
