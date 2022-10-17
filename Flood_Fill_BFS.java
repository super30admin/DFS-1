//TC : O(m * n)
//SC : O(m * n)
//BFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image == null || image[0].length == 0 || image[sr][sc] == color)
            return image;
        
        int m = image.length;
        int n = image[0].length;
        
        int dirs[][] = new int[][]{{0,-1}, {-1, 0}, {0, 1}, {1, 0}};
        
        Integer[] loc = new Integer[]{sr, sc};
        
        Queue<Integer[]> q = new LinkedList<>();
        
        q.add(loc);
        
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        
        while(!q.isEmpty()) {
            Integer[] lo = q.poll();
            for(int[] k : dirs) {
                    int nr = k[0] + lo[0];
                    int nc = k[1] + lo[1];
                    if(nr < m && nr >= 0 && nc < n && nc >= 0 && 
                       oldColor == image[nr][nc]) {
                        image[nr][nc] = color;
                        q.add(new Integer[]{nr,nc});
                    }
                }
        }
        
        return image;
        
    }
}
