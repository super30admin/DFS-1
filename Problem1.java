// ## Problem1 (https://leetcode.com/problems/flood-fill/)

// Time Complexity : BFS - O(M*N)
// Space Complexity : BFS - O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach


class Solution {
    private int[][] dirs={{0,1}, {1,0}, {0,-1}, {-1,0}};

    //1. BFS
    // Time - O(M*N)
    // Space - O(M*N)
    private int[][] bfsHelper(int[][] image, int sr, int sc, int color){
        int baseColor=image[sr][sc];
        int m=image.length;
        int n=image[0].length;

        // Check if new color is same as original color
        if(baseColor==color)    return image;

        Queue<Integer> q=new LinkedList<>();
        image[sr][sc]=color;
        q.add(sr);
        q.add(sc);

        while(!q.isEmpty()){
            int r=q.poll();
            int c=q.poll();

            // Check all neighbors
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                // Bounds check
                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==baseColor){
                    // Color current cell and add to queue
                    image[nr][nc]=color;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int m, int n, int baseColor){
        //base
        if(sr<0||sc<0||sr==m||sc==n||image[sr][sc]!=baseColor)    return;

        //logic
        // color current cell and run dfs on it
        image[sr][sc]=color;
        for(int[] dir:dirs){
            int nr=sr+dir[0];
            int nc=sc+dir[1];
            dfs(image, nr, nc, color, m, n, baseColor);
        }
    }

    //2. DFS
    // Time - O(M*N)
    // Space - O(M*N)
    private int[][] dfsHelper(int[][] image, int sr, int sc, int color){
        int baseColor=image[sr][sc];
        int m=image.length;
        int n=image[0].length;

        if(baseColor==color)    return image;

        dfs(image,sr,sc,color,m,n, baseColor);

        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //1. BFS
        //return bfsHelper(image, sr, sc, color);

        //2. DFS
        return dfsHelper(image,sr,sc,color);
    }
}