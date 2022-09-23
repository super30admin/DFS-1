
// BFS Solution
public class FloodFillBFS {
    // BFS Solution
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        
        int startColor = image[sr][sc];
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        
        while(!q.isEmpty()){
            int size = q.size();
                int cr = q.poll();
                int cc = q.poll();
                for(int[] dir:dirs){
                    int r = dir[0]+cr;
                    int c = dir[1]+cc;
                    
                    if(r>=0&&r<m && c>=0&&c<n && image[r][c]==startColor){
                        q.add(r);
                        q.add(c);
                        image[r][c]=color;
                    }
                }
        }
        return image;
    }    
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)

// DFS Solution
public class FloodFillDFS {
        // DFS Solution
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image==null || image[sr][sc] == color) return image;
            int m = image.length;
            int n = image[0].length;        
            int startColor = image[sr][sc];
            
            dfs(image,sr,sc,color,m,n,startColor);
            return image;
    }
        private void dfs(int[][] image, int sr, int sc, int color, int m, int n,int startColor){
            //base
            if(sr<0 || sr==m || sc<0 || sc==n || image[sr][sc]!=startColor) return;
            
            //logic
            image[sr][sc] = color;
            for(int[] dir:dirs){
                int r = dir[0]+sr;
                int c = dir[1]+sc;
                dfs(image,r,c,color,m,n,startColor);
            }
            
        }
}