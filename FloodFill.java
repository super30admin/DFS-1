// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
   
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //null
        if(image==null || image.length==0) return image;
        int [][] dirs = new int [][] { {0,1},{0,-1},{1,0},{-1,0} };
        int m = image.length;
        int n = image[0].length;

        int origColor=image[sr][sc];
        if(image[sr][sc] == color) return image;
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int cr = q.poll();
            int cc = q.poll();
            for(int[] dir : dirs){
                int nr=cr + dir[0];
                int nc=cc + dir[1];
                if( nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc] == origColor){
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
                
            }
        }
        return image;
    }

    
}



// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Using DFS

class Solution {
   
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        if(image==null || image.length==0)
            return image;
        int m = image.length;
        int n = image[0].length;
        int origColor=image[sr][sc];
        if(origColor==color)
            return image;
        dfs(image,sr,sc,color,dirs,m,n,origColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int[][] dirs, int m,int n,int orig){
        if(sr<0 || sr==image.length || sc<0 || sc==image[0].length || image[sr][sc]!=orig )
            return;
        image[sr][sc]=color;
        for(int[] dir : dirs){
            int nr=sr + dir[0];
            int nc=sc + dir[1];
            dfs(image,nr,nc,color,dirs,m,m,orig);
        }
    }
    
}