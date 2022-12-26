// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        if(mat == null || mat.Length == 0) return mat;
        var m  = mat.Length; var n = mat[0].Length;
        var dirs = new List<(int, int)> { (0,1), (0, -1), (-1, 0), (1,0)};
        var q = new Queue<(int Row, int Col)>();
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.Enqueue((i,j));
                }
                else{
                    mat[i][j] = -1;
                }               
            }
        }     
        int dist = 1; 
        while(q.Count > 0)
        {
            var count = q.Count;
            for(int i = 0; i < count; i++)
            {
                var curr= q.Dequeue();                           
                foreach(var dir in dirs)
                {
                    var row = curr.Row + dir.Item1;
                    var col = curr.Col + dir.Item2;
                    if(row >= 0 && col >= 0 && row < m && col < n && mat[row][col] == -1)
                    {
                        mat[row][col] = dist;
                        q.Enqueue((row, col));                    
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
