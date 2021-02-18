// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Checking every neighbour at each point if it has the color we need to change.
class Solution {
    int initialcolor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        initialcolor=image[sr][sc];
        DFS(image,sr,sc,newColor,x);
        return image;
    }
    
    public void DFS(int[][]image , int x, int y, int color)
    {   
        int row=image.length;
        int col= image[0].length;
        if(image[x][y]!=initialcolor)
            return;
        else{
            if(image[x][y]!=color )
                image[x][y]=color;
            if(x-1>=0 && image[x-1][y]!=color) DFS(image,x-1,y,color);
            if(y-1>=0 && image[x][y-1]!=color) DFS(image,x,y-1,color,);
            if(x+1<row && image[x+1][y]!=color) DFS(image,x+1,y,color);
            if(y+1<col && image[x][y+1]!=color) DFS(image,x,y+1,color);
        }
        
    }
}