// Time Complexity : O(m*n). m is the number of rows and n is the number of columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     
        if(image[sr][sc]==newColor) return image;
        
        int color = image[sr][sc];
        Queue<int[]> q= new LinkedList();
        q.add(new int[]{sr,sc});
        image[sr][sc]=newColor;
        
        int dirs[][] =new int[][]{
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
        }; 
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            
            for(int i=0;i<dirs.length;i++){
            int[] dir = dirs[i];
            
                 
            int r= dir[0]+current[0];
            int c= dir[1]+current[1];
            
            if(r>=0&&r<image.length&&c>=0 && c<image[0].length&& image[r][c]==color)                     {
                q.add(new int[]{r,c});
                image[r][c]=newColor;
            }
        
            }
        }
       
        
        return image;
    }
}
