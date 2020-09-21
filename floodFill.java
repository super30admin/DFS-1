    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/flood-fill/
    Time Complexity for operators : o(m*n)
    Extra Space Complexity for operators : o(m*n)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach:
                              
            Approach :- 
                    A. We will use DFS here instead of BFS. BFS approach will only process one direction at a time
                       Here we have to traverse in all the directions.
                    B. Initially, if image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor
                       return image.
                    C. Then, we will call dfs with image, sr,sc oldCOlor and newCOlor values.
                    D. in dfs(int[][] image, int i, int j ,int oldColor, int newColor) function, we will change the color to the newColor.
                    E. Then, we will traverse in all 4 directions, if directions matches with oldColor then agin we will
                       call dfs on that direction as well.
                    F. in the end, we will return image.

       */

class floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor)
            return image;
        
        dfs(image,sr,sc,image[sr][sc],newColor);
        
        return image;
    }
    
    int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    
    private void dfs(int[][] image, int i, int j ,int oldColor, int newColor){
        
        image[i][j] = newColor;
        
        for(int dirs[] : directions){
            int r = i + dirs[0];
            int c = j + dirs[1];
            
            if(r>=0 && r< image.length && c>=0 && c < image[0].length && image[r][c] == oldColor)
                dfs(image,r,c,oldColor, newColor);
        } 
    }
}