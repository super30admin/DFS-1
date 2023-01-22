// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
//in this approach we check if the current color is equal to the given color then we do nothing. otherwise we add curr in the queue. We process 
//all the nieghbors and check if it is equal to the original color. If yes we change it to the given color and add it to the queue.
//bfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length ==0)return image;
        int[][] dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = image.length;
        int n = image[0].length;
        Queue<int []> q = new LinkedList<>();
        int temp = image[sr][sc];
        if(temp == color) return image;
        image[sr][sc] = color;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            // int size= q.size();
            // for(int i=0;i<size;i++){
                int [] curr = q.poll();
                for(int [] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc] == temp){
                        image[nr][nc] = color;
                        q.add(new int[]{nr,nc});
                    }
                }
            // }
            
        }
        return image;
    }
}

//dfs
class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length ==0)return image;
        dirs = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = image.length;
        int n = image[0].length;
        int temp = image[sr][sc];
        if(temp == color) return image;
        // image[sr][sc] = color;
        dfs(image,sr,sc,m,n,temp,color);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int m, int n, int temp,int color){
        //base
        if(sr<0 || sr>=m || sc<0 || sc>=n || image[sr][sc] != temp)return;
        image[sr][sc] = color;
        //logic
        for(int [] dir: dirs){
            int nr = sr+dir[0];
            int nc = sc + dir[1];
            dfs(image, nr,nc,m,n,temp,color);
        }
    }
}