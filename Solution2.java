// Time Complexity :O(m*n) size of image array
// Space Complexity : O(m*n) maximum element in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution2 {
    
    //BFS
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image[0].length==0)
            return image;
        int oldcolor;
        oldcolor=image[sr][sc];
        image[sr][sc]=newColor;
        if(newColor==oldcolor)
            return image;
        int m=image.length;
        int n=image[0].length;
        Queue<int []> q= new LinkedList<>();
        q.add(new int[] {sr,sc});
        int dirs[][]=new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int [] curr= q.poll();
            for(int[] dir:dirs){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==oldcolor){
                    image[nr][nc]=newColor;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return image;
    }

    //DFS
// Time Complexity :O(m*n) size of image array
// Space Complexity : O(m*n) maximum element in the recursive stack
    int dirs[][];
    int m;
    int n;
    int oldcolor;
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image[0].length==0)
            return image;
        oldcolor=image[sr][sc];
        if(newColor==oldcolor)
            return image;
        dirs=new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
        m=image.length;
        n=image[0].length;
       
        dfs(image,sr,sc,newColor);
        return image;
    }
    private void dfs(int[][] image, int i,int j,int color){
        
        //logic
        image[i][j]=color;
        for(int[] dir:dirs){
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==oldcolor)
            dfs(image,nr,nc,color);
            }
        }
}
