class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        
        image[sr][sc] = newColor;
        q.add(new int[] {sr,sc});
        
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == color){
                    image[nr][nc] = newColor;
                    q.add(new int[] {nr,nc});
                }
            }
        }
        
        return image;
        
    }
    
}