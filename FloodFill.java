// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use recursive calls to all the 4-directionally adjacent neighbors from the current element, and then replace all the old colors in the neighboring elements with the new color.

public class FloodFill {

    //Solution 1 : DFS
    int newCol;
    int oldCol;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        newCol = newColor;
        oldCol = image[sr][sc];
        if(image == null || oldCol == newCol) return image;

        helper(image, sr, sc);
        return image;       
    }
    
    private void helper(int[][] image, int row, int col){
        
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldCol )
            return;

        image[row][col] = newCol;

        helper(image, row, col+1);
        helper(image, row+1, col);
        helper(image, row, col-1);
        helper(image, row-1, col);
    }

    //Solution 2 : BFS
    // public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    //     int oldColor = image[sr][sc];
    //     if(image == null || oldColor == newColor) return image;
        
    //     int m = image.length;
    //     int n = image[0].length;
        
    //     Queue<int []> q = new LinkedList<>();
    //     q.add(new int[]{sr, sc});
    //     image[sr][sc] = newColor;
        
    //     int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    //     while(!q.isEmpty()){
            
    //         int [] curr = q.poll();

    //         for(int i = 0; i < 4; i++){
    //             int row = curr[0] + dir[i][0];
    //             int col = curr[1] + dir[i][1];
                
    //             if(row >= 0 && row < m && col >= 0 && col < n && image[row][col] == oldColor){
    //                 image[row][col] = newColor;
    //                 q.add(new int[]{row, col});
    //             }
    //         }
    //     }
    //     return image;
    // }
}
