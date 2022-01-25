//BFS solution

//Time Complexity: m*n
//Space Complexity: m*n

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image [sr][sc] == newColor )return image;
        int[][] dirs = new int [][] {{0,1},{0,-1},{1,0},{-1,0}};
        int m = image.length;
        int n = image[0].length;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        int orgColor = image[sr][sc];
        image[sr][sc] = newColor;
        while(!q.isEmpty())
        {
            int x = q.poll();
            int y = q.poll();
            
            for(int[] dir : dirs)
            {
                int nr = x+dir[0];
                int nc = y+dir[1];
                
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == orgColor)
                {
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newColor;
                }
            }
            
        }
        return image;
        
    }
}