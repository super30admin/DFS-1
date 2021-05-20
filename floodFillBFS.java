// Time complexity - O(mxn)
// Space complexity - O(mxn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
       
        
        if(image.length == 0|| image[0].length == 0 || image == null){
            
            return image;
        }
        
        Queue<Integer> q1 = new LinkedList<>();
        int r = image.length;
        int c = image[0].length;
        
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        if(oldColor == newColor){
            
            return image;
        }
        q1.add(sr);
        q1.add(sc);
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,1,-1,0};
        
        while(!q1.isEmpty()){
            
            int currX = q1.poll();
            int currY = q1.poll();
            for(int i = 0; i < 4; i ++){
                
                int ndx = currX + dx[i];
                int ndy = currY + dy[i];
                
                if(isValid(r,c,ndx,ndy)){
                    
                    if(image[ndx][ndy] == oldColor){
                        image[ndx][ndy] = newColor;
                        q1.add(ndx);
                        q1.add(ndy);
                        
                    }
                    
                    
                }
                
            }
        }
        
        return image;
    }
    
    private boolean isValid(int r, int c, int ndx, int ndy){
        if(ndx < r && ndx > -1 && ndy < c && ndy > -1){
            
            return true;
        }
        return false;
    }
}