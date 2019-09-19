//Time complexity: O(V+E) => O(N)
//Space Complexity: O(V+E) => O(N)
//Tried on leetcode and accepted attempts: 1
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //Check the initial pixel if already same color
        if(image[sr][sc]==newColor)
        {
            return image;
        }
        //dfs function to color the pixels.  
        fill(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    
    //takes image coordinates of initial pixel, color at given coordinates and the new color as input
    public void fill(int[][] image, int i, int j, int color, int newColor)
    {
        //base case
        //check if coordinates are out of bound or if the color at the i,j coordinate not same as the initial pixel color
        if(i<0||i>=image.length||j<0||j>=image[i].length||image[i][j]!=color) return;
        //else color the pixel with new color
        image[i][j] = newColor;
        //color the 4 adjacent pixels as well recursively call the fill function for adjacent pixels
        fill(image,i+1,j,color,newColor);
        fill(image,i-1,j,color,newColor);
        fill(image,i,j+1,color,newColor);
        fill(image,i,j-1,color,newColor);
    }
}