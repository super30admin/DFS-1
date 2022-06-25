import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(mxn)
//Space Complexity: O(mxn)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        //null case check
        if(mat == null && mat.length == 0) return mat;
        
        //calculatiing the row and column lengths
        int m = mat.length;
        int n = mat[0].length;
        
        //creating a directions matrix that we will use to move in the four directions
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        //creating a queue to store matrix elements and help us with breath first search
        Queue <int []> que = new LinkedList<>();
        
        //we will be adding all the zeroes to the queue
        //and replacing the values of all the '1's to '-1'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                {
                    que.add(new int[] {i, j});
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        
        //creating a distance variable which will help us find the 1 at the farthest distance from '0'
        int dist = 0;
        //looping until all the elements are popped out
        while (!que.isEmpty())
        {
            //the size of each level of the bfs search that we will encounter
            int size = que.size();
            //looping for each individual level
            for (int i = 0; i < size; i++)
            {
                //setting curr as the topmost element of the queue and popping it out
                int [] curr = que.poll();
                //looping to move in all four directions of the curr elements
                for(int [] dir: dirs) 
                {
                    //calcualting the new row and new column that will help us move in the four directions
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    
                    //bounds check and finding a '-1' in the matrix(i.e.previously a '1')
                    //once reached such an element, we replace the value with the distance it took to get there
                    //we also add it to the queue so we can reach all it's connected '1's
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1)
                    {
                        mat[nr][nc] = dist + 1;
                        que.add(new int[] {nr, nc});
                    }
                }
            }
            //we increment the distance after the for loop as we move to the next level of bfs
            dist++;
        }
        //we return the matrix after all the elements in the queue finish the breadth first search
        return mat;
    }
}