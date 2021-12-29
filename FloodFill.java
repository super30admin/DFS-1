// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int currColor = image[sr][sc];
        
        if(currColor == newColor){
            return image;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {sr,sc});
      
        int[][] directions = new int[][] {{0,-1},{0,1},{-1,0},{1,0}};
        
        while(!queue.isEmpty()){
             
            int[] curr = queue.poll();
            image[curr[0]][curr[1]] = newColor;
            for(int[] dir : directions ){
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                
                if(row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == currColor){
                    queue.add(new int[] {row,col});
                   
                }
                    
            }
        }
        
        return image;
        
    }
}