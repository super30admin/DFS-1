// since we have connected components we can use either dfs or bfs
//solved using bfs
//with every encoutered from the starting point, if the pixel is same color in the acceptable direction
// color the pixel with new color

//TC:O(mxn)
//SC:O(mxn)
//WORKS ON LEETCODE

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      if(image[sr][sc] == newColor) return image;
         if(image == null || image.length == 0) return image;
 
         Queue <int[]> q = new LinkedList <>();
 
         int color = image[sr][sc];
 
         q.add(new int [] {sr, sc});
 
         image[sr][sc] = newColor;
 
         int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
 
  
         while(!q.isEmpty())
         {
             int[] cr = q.poll();
 
             for(int [] dir: dirs)
             {
                 int nr = cr[0] + dir[0];
                 int nc = cr[1] + dir[1];
 
                 if(nr >= 0 && nr< image.length && nc>=0 && nc < image[0].length  && 
                     image[nr][nc] == color)
                 {
                     q.add(new int [] {nr,nc});
                     image[nr][nc] = newColor;
                 }
             }
 
         }
         return image;
     }
 }


//dfs
//solution would be to pick the starting and in one direction keep looking for 1's
//recursively come back to the node, then go to other direction same color nodes

//TC: O(mxn)
//SC: O(mxn)

class Solution

{ 

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor)

{ if (image[sr][sc] == newColor)

return image; 

int color = image[sr][sc]; 

dfs(image,sr,sc,newColor, color); 

return image; 

} 

private void dfs(int[][] image, int sr, int sc, int newColor, int color)

{ // base case 

if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) 

return; 

//logic 

image[sr][sc] = newColor; 

int [][] dirs = new int[][] 

{{0,1}, {1,0}, {-1,0}, {0,-1}}; 

for(int[] dir : dirs)

{ 

int r = sr + dir[0]; 

int c = sc + dir[1]; 

dfs(image, r , c, newColor, color); 

} 

