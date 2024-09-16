// Time complexity - O(m*n)
// Space complexity - O(m*n)

// BFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int []dir : dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if(r >= 0 && r < image.length && c >= 0 && 
                   c < image[0].length && image[r][c] == color){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        
        return image;
    }
}
