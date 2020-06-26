
// Time Complexity : O(n)
//Space Complexity : O(n) 
//Did this code successfully run on Leetcode : Yes

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        Queue<int []> q = new LinkedList<>();
        
        int color = image[sr][sc];
        
        q.add(new int[]{sr, sc});
        
        image[sr][sc] = newColor;
        
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1,0}};
            
            for(int[] dir : dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                
                if(c < image[0].length && c>=0 && r < image.length && r>= 0 && image[r][c] == color )
                {
                    image[r][c] = newColor;
                    q.add(new int[]{r, c});
                }           
            }
        }
        
        return image;
    }
}


