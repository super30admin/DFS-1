// time complexity O(m*n)
// space complexity  O(m*n)
// Approach - we will start from given cell, and check its neighbours, if they are of oroginal color, 
//mark them with new color. We will go over marking neighbours with new color until we found cell without
// orginal color
public class Solution
{
    public int[][] FloodFill(int[][] image, int sr, int sc, int color)
    {
        Queue<int[]> bfs = new Queue<int[]>();
        int[][] dir = new int[][] { [1, 0], [-1, 0], [0, 1], [0, -1] };
        if (image[sr][sc] == color)
        {
            return image;
        }
        if (image == null || image.Length == 0)
        {
            return image;
        }
        int org = image[sr][sc];
        // DFS
        helper(image, sr, sc, dir, color, org);

        //BFS
        // bfs.Enqueue([sr,sc]);
        // while(bfs.Count() > 0)
        // {
        //     int[] arr = bfs.Dequeue();
        //     image[arr[0]][arr[1]] = color;

        //     foreach(var i in dir)
        //     {
        //         int r= arr[0]+i[0]; 
        //         int c= arr[1]+i[1];
        //         if(r>=0 && c>= 0 && r< image.Length && c < image[0].Length && image[r][c] == org)
        //         {
        //             bfs.Enqueue([r,c]);
        //             image[r][c] = color;
        //         }
        //     }
        // }
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int[][] dir, int color, int org)
    {
        // base
        if (sr < 0 || sc < 0 || sr == image.Length || sc == image[0].Length || image[sr][sc] != org)
        {
            return;
        }

        // logic
        image[sr][sc] = color;
        foreach (var i in dir)
        {
            int r = sr + i[0];
            int c = sc + i[1];

            helper(image, r, c, dir, color, org);
        }
    }
}