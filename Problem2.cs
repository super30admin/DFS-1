public class NearestZero
    {
        // Time Complexity : O(m * n) - have to traverse entire matrix
        // Space Complexity : O(m * n) - queue will have almost all elements from matrix in the worst case 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        int[][] directions;
        public int[][] UpdateMatrix(int[][] matrix)
        {
            if (matrix == null || matrix.Length == 0) return matrix;

            int m = matrix.Length;
            int n = matrix[0].Length;

            Queue<int[]> q = new Queue<int[]>();
            directions = new int[][] {
                new int[] { 0, 1 }, //right
                new int[] { 0, -1 }, //left
                new int[] { 1, 0 }, //down
                new int[] { -1, 0 } //up
            };

            //adding all 0s into the queue and 1s to -1
            for (int i = 0; i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if (matrix[i][j] == 0)
                        q.Enqueue(new int[] { i, j });
                    else
                        matrix[i][j] = -1;
                }
            }
            int distance = 1;
            while(q.Count > 0)
            {
                int size = q.Count;
                for(int i = 0; i < size; i++)
                {
                    int[] curr = q.Dequeue();
                    foreach (var dir in directions)
                    {
                        int nr = curr[0] + dir[0];
                        int nc = curr[1] + dir[1];

                        //bounds check
                        if(nr >= 0 && nr < m && nc >=0 && nc < n && matrix[nr][nc] == -1)
                        {
                            q.Enqueue(new int[] { nr, nc });
                            matrix[nr][nc] = distance;
                        }
                    }
                }
                //increment the distance once level is complete
                distance++;
            }



            return matrix;
        }
}
