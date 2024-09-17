//dfs
// Time Complexity : O(N*M) traverse all nodes in worst case
// Space Complexity : O(N*M) size of implicit call stack when calling dfsVisit function
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve before class


// Your code here along with comments explaining your approach

//dfs
//T:O(N*M) traverse all nodes in worst case
//S: O(N*M) size of implicit call stack when calling dfsVisit function
class Solution {
    
            //arrays to traverse the matrix
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //base checks
        if(image == null) return image;
        
        int m = image.length; //row
        if(m == 0) return image;
        int n = image[0].length; // col
        
        if(image[sr][sc] == newColor) return image;
        
        dfsVisit(image, image[sr][sc], sr, sc, newColor);
        
        return image;
    }
    
    private void dfsVisit(int[][] image, int srcColor, int row, int col, int newColor){
        
        //visited
        image[row][col] = newColor;
        
        //traverse 4-directional neighbours
        for(int i=0; i<4 ;i++){
            int x = row + dx[i];
            int y = col + dy[i];
            
            //check is the new row and col is out of index and having color same as source color
            if(isValid(image, x, y) && image[x][y] == srcColor){
                dfsVisit(image, srcColor, x, y, newColor);
            }
        }       
        
    }
    
    private boolean isValid(int[][] image, int row, int col){
        return row >=0 && row < image.length && col >= 0 && col < image[0].length;
    }
}