// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
  if(image == null || image.length==0 || newColor == image[sr][sc]) return image;
        int original = image[sr][sc];

        Queue<int []> q = new LinkedList<>();

        q.add(new int []{sr,sc});
        image[sr][sc] = newColor;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){

            int [] cur = q.poll();            
            for(int [] dir: dirs){

                int r = dir[0]+cur[0];
                int c = dir[1]+cur[1];

                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == original){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});  // to avoid re-processing we are changing the color here 
                }
            }     
        }
        return image;
    }
}