// Time Complexity : O(M * N)
// Space Complexity : O(M * N) -> Stack Sapce
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

private void dfs(int[][]image,int r,int c,int color,int newColor){

        // base condition
        if(r< 0||r>=image.length||c< 0||c>=image[0].length||image[r][c]!=color)return;

        // Color with new one
        image[r][c]=newColor;

        // Just move up, down, left and right
        dfs(image,r-1,c,color,newColor);
        dfs(image,r+1,c,color,newColor);
        dfs(image,r,c-1,color,newColor);
        dfs(image,r,c+1,color,newColor);

        }

public int[][]floodFill(int[][]image,int sr,int sc,int color){

        // If New Color and Old Color are same Just return there is no meaning to go with it.
        // Its already solved
        if(image[sr][sc]==color)return image;

        dfs(image,sr,sc,image[sr][sc],color);

        return image;

        }
        }