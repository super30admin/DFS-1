//bfs solution
//make all the 1's to -1 initially 
//then going to next level, make the nearest -1's as 1 distance from nearest 0
// increase the distance of next level by 1
//in the end turn all -1's to 0
//above is a bfs solution 

//TC : O(mxn)
//SC: O(mxn)
//traversing through all the nodes at all levels

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        //null
        if(matrix == null || matrix.length == 0) return matrix;

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int []> q = new LinkedList<>();

        //making all the 1's to -1
        //adding all the 0's to the queue
        for(int i=0; i< m; i++)
        {
            for(int j = 0; j<n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
                else
                {
                    matrix[i][j] = -1;
                }
            }
        }

        int dist = 1;
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};

        //starting with all babies of 0's making them as distance 1
        //continuing till queue is empty
        //or found minimum direction for all elements
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int k = 0; k<size; k++)
            {
                int[] curr = q.poll();
                for(int[] dir: dirs)
                {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                     if(nr >= 0 && nr< m && nc < n && nc>=0 && 
                    matrix[nr][nc] == -1)
                    {
                        q.add(new int[]{nr,nc});
                        matrix[nr][nc] = dist;
                    }
                }
            }
            dist++;
        } 
    return matrix;
    }
}


//dfs solution
//for every 1, find the nearest 0 and do that repeatedly till we exhaust all directions of 1
//up,down, left and right
//since, every 1 will be checking with it's neighbor the 1, we can visualize this as a DP problem 
//as it has repeated subproblems

//TC: O(mxn)
//SC: O(mxn)