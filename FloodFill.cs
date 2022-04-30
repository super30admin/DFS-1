// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//DFS
int m, n, color;
int[][] dirs;
public int[][] FloodFill(int[][] image, int sr, int sc, int newColor) {

    if(image == null || image.Length == 0 || image[sr][sc] == newColor)
        return image;
    
    m = image.Length;
    n = image[0].Length;
    color = image[sr][sc];
    dirs = new int[][] {new int[] {0,1}, new int[] {0,-1}, new int[] {1,0}, new int[] {-1,0}};

    dfs(image, sr, sc, newColor);

}

private void dfs(int[][] image, int sr, int sc, int newColor) 
{
    //base condition
    if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color)
        return;

    //logic
    image[sr][sc] = newColor;
    foreach(var dir in dirs)
    {
        int nr = dir[0] + sr;
        int nc = dir[1] + sc;
        dfs(image, nr, nc, newColor);
    }
}


//BFS
//O(m*n), O(1)
int m, n, color;
int[][] dirs;
public int[][] FloodFill(int[][] image, int sr, int sc, int newColor) {

    if(image == null || image.Length == 0 || image[sr][sc] == newColor)
        return image;
    
    m = image.Length;
    n = image[0].Length;
    color = image[sr][sc];
    dirs = new int[][] {new int[] {0,1}, new int[] {0,-1}, new int[] {1,0}, new int[] {-1,0}};

    Queue<int[]> queue = new Queue<int[]>();
    image[sr][sc] = newColor;
    queue.Enqueue(new int[] {sr, sc});

    while(queue.Count > 0)
    {
        var curr = queue.Dequeue();

        foreach(var dir in dirs)
        {
            int nr = dir[0] + curr[0];
            int nc = dir[1] + curr[1];

            if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color)
            {
                image[nr][nc] = newColor;
                queue.Enqueue(new int[] {nr, nc});
            }
        }
    }
    return image;
}