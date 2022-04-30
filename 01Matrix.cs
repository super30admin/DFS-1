// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//BFS
	// 2) We traverse and change to 1 to -1and add 0 row and column to queue
	// 3) Run bfs on queue until empty
	// 	a. dequeue
	// 	b. Kkep level
	// 	c. And increment level +1 , whenver we reach to new -1

int m, n;
public int[][] UpdateMatrix(int[][] mat) {
    
    if(mat == null || mat.Length == 0)
        return mat;

    m = mat.Length;
    n = mat[0].Length;

    var dirs = new int[][]{new int[] {0,1}, new int[] {0, -1}, new int[] {1, 0}, new int[] {-1,0}};
    Queue<int[]> queue = new Queue<int[]>();

    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(mat[i][j] == 1)
                mat[i][j] = -1;
            else
                queue.Enqueue(new int[] {i, j});
        }
    }

    int dist = 1;
    while(queue.Count > 0)
    {
        int size = queue.Count;
        for(int i = 0; i < size; i++)
        {
            var curr = queue.Dequeue();
            foreach(var dir in dirs)
            {
                int nr = curr[0] + dir[0];
                int nc = curr[0] + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1)
                {
                    mat[nr][nc] = dist;
                    queue.Enqueue(new int[] {nr, nc});
                }
            }
            dist++;
        }
    }
    return mat;
}