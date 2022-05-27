// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //base
        if(image==null || image.length==0){
            return image;
        }
        
        int m = image.length;
        int n = image[0].length;
        
        int oldcolor = image[sr][sc];
                
        if(oldcolor!=newColor){
            dfs(image, sr, sc, oldcolor, newColor);
        }
        return image;

    }
    
    private void dfs(int[][] image, int i, int j, int oldcolor, int newColor){
        int m = image.length;
        int n = image[0].length;
        if(i<0 || j<0 || i>=m || j>=n || image[i][j]!=oldcolor){
            return;
        }
        image[i][j]=newColor;
        dfs(image, i+1, j, oldcolor, newColor);
        dfs(image, i-1, j, oldcolor, newColor);
        dfs(image, i, j+1, oldcolor, newColor);
        dfs(image, i, j-1, oldcolor, newColor);
    }
    
}

//BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //base
        if(image==null || image.length==0 || image[sr][sc]==newColor){
            return image;
        }
        
        int m = image.length;
        int n = image[0].length;
        
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        
        int oldcolor = image[sr][sc];
        
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int k=0;k<size;k++){
                int[] value = q.poll();
                
                for(int[] dir:dirs){
                    int i = value[0]+dir[0];
                    int j = value[1]+dir[1];
                    
                    if(i<0 || j<0 || i>=m || j>=n || image[i][j]!=oldcolor){
                        continue;
                    }
                    image[i][j]=newColor;
                    q.add(new int[]{i,j});  
                        
                }
            }
            
        }
        return image;
    }
}
