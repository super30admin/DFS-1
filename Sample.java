// Time Complexity : O(m*n)
// Space Complexity : O(m*n) as traversing all four directions and adding to queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) // if already the newcolor at the point
            return image;
      
        int color = image[sr][sc]; // save the oldcolor at point
        int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        int m = image.length;
        int n = image[0].length;
     Queue<int[]> q = new LinkedList<>(); // to process the image points
        q.add(new int[]{sr,sc}); //adding to queue
        
        image[sr][sc] = newColor; // making the color at point as newcolor
            
        while(!q.isEmpty()) //till queue is not empty
        {
            int curr[] = q.poll(); //remove the coordinates of point from queue
            for(int[] dir: dirs) //traverse in all four directions
            {
                int r = curr[0] + dir[0]; //find the row and column for the neighbours
                int c = curr[1] + dir[1];
                if(r>=0 && c>=0 && r<m && c<n && image[r][c]== color) // check bounds and if the neighbour has same color as oldcolr at starting point
                {
                    image[r][c] = newColor; //make it to newcolor
                    q.add(new int[] {r,c}); //add it to the queue
                }
            }
            
            
        }
        
        return image;
        
}
}

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    int dirs[][]; //global declarations
    int m; int n;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) // if already the newcolor at the point
            return image;
      
        color = image[sr][sc];  // save the oldcolor at point
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}}; // to traverse neighbours in all four directions
         m = image.length;
         n = image[0].length;
    
        dfs(image, sr, sc, newColor); //calling dfs on the given point
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor)
    {
        //base
        if(sr<0 || sc<0 || sr>=m || sc>=n || image[sr][sc]!=color) // check bounds and if the neighbour has same color as oldcolr at starting point
            return;
        
        //logic
            image[sr][sc] = newColor; //set the color at the point as newcolor
        
        for(int[] dir:dirs) //traverse all 4 directions
        {
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor); //call dfs on the new cell
        }
    }
}

// Time Complexity : O(m*n)
// Space Complexity : O(m*n) as traversing all four directions and adding to queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};
       for(int i=0; i<m ; i++) //adding all zeros position to queue
       {
           for(int j=0; j<n ; j++)
           {
            if(matrix[i][j] == 0)
                q.add(new int[]{i,j});
               else
                   matrix[i][j] = -1; // if not zero, making them -1 so that we dont have to maintain visited array and can keep track of vistied nodes using the upadted distance value
           }
       }
        int dist = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++) //level processing
            {
               int curr[] = q.poll(); //getting front position out
            
            for(int[] dir: dirs) //traversing all four directions
            {
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                
                if(r>=0 && c>=0 && r<m && c<n && matrix[r][c] ==-1){ // checking bounds and if value is -1 i.e unvistied
                     matrix[r][c] = dist;    //making equal to distance based on level
                     q.add(new int[]{r,c}); //adding it to queue
                }
                    
            } 
            }
            dist++; //incrementing distance levelwise
            
        }
        
        return matrix;
    }
}