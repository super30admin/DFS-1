Flood fill
Time: O(m*n)
Space: O(m*n)


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       
        if(image==null || image.length==0 || image[sr][sc] == newColor) return image;
        
        
        int m=image.length;
        int n= image[0].length;
        
        Queue<int[] > q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int currImage = image[sr][sc];
        image[sr][sc] = newColor;
        int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        
        while(!q.isEmpty()){
         int[] curr = q.poll();
            
            for(int[] dir:dirs){
                int r = curr[0]+dir[0];
                int c =curr[1]+dir[1];
                
                if(r>=0 && r<m && c >=0 && c < n && image[r][c] == currImage){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        
        
        return image;
    }
}


