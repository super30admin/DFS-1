// Time Complexity : O(rows*columns)
// Space Complexity : O(rows*columns)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        // dfs(image, image.length, image[0].length, sr, sc, image[sr][sc], newColor, new HashSet<Integer>());
        
        Queue<Integer> q = new LinkedList<>();
        int rowLen = image.length;
        int colLen = image[0].length, connected=image[sr][sc];
        if(connected==newColor)
            return image;
        int ax[] = {-1,0,1,0};
        int ay[] = {0,1,0,-1};
        
        q.add(sr*colLen+sc);
        while(!q.isEmpty()){
            int val = q.poll();
            int x1 = val/colLen;
            int y1 = val%colLen;
            image[x1][y1]=newColor;
            
            for(int i=0;i<4;i++){
             int x=x1+ax[i];
             int y=y1+ay[i];
            
                if(x>=0 && y>=0 && x<rowLen && y<colLen && image[x][y]==connected){
                    q.add(x*colLen+y);
                }
            }
            
        }
        return image;
        
    }
}

// Time Complexity : O(rows*columns)
// Space Complexity : O(rows*columns)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor==image[sr][sc])
            return image;
        dfs(image, image.length, image[0].length, sr, sc, image[sr][sc], newColor);
        return image;
        
    }
    
    public void dfs(int[][] image, int rowLen, int colLen, int sr, int sc, int connected, int newColor) {
        int ax[] = {-1,0,1,0};
        int ay[] = {0,1,0,-1,0};
        image[sr][sc] = newColor;
        for(int i=0;i<4;i++){
            int x=sr+ax[i];
            int y=sc+ay[i];
            
            if(x>=0 && y>=0 && x<rowLen && y<colLen && image[x][y]==connected){
                image[x][y]=newColor;
                dfs(image,rowLen,colLen,x,y,connected, newColor);
            }
        }
    }
}
}
