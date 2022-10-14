//Using BFS Approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color)
            return image;
        
        int m = image.length;
        int n = image[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        
        int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir : dirs){
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor){
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}

//Time Complexity : O(m*n)
//Space Complexity : O(m*n)