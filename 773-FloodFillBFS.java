/**LC-773
 * Time Complexity : O(MN) 
 * Space Complexity : O(MN) 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. start with index sr and sc
 2. If color at sr and sc == newColor return
 3. now explore all 4 dirs from sr,sc and change the color if current color == startColor

 */
class Solution {
    
    int startColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //edge 
        if(image == null || image.length == 0) return image;
        startColor = image[sr][sc];
        if(startColor == newColor) return image;
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{sr, sc});
        int[][] dirs = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = newColor; 
            for(int[] dir: dirs){
                
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if(r >= 0 && r< image.length && c >=0 && c<image[0].length && image[r][c] == startColor){
                    q.add(new int[]{r, c});     
                }
            }
        }
        
        return image;
            
    }
    
  
}