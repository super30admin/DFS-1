// Time Complexity : O(n*m) n - rows  m - columns
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Yes 


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int m = image.length;
        int n = image[0].length;
        int OgColor = image[sr][sc]; // Mark Original color
        if(OgColor == newColor) return image; 
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newColor;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()) // Apply BFS
        {   
            int row = q.poll();
            int col = q.poll();
            
            for(int [] dir : dirs)
            {
                int r = row + dir[0];
                int c= col + dir[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c]==OgColor)
                {   
                    image[r][c] = newColor;
                    q.add(r);
                    q.add(c);   
                }
            }
        }
        
        return image;
    }
}