//Time Complexity: O(m*n), where m is the no. of rows & n is the no. of columns
//Space Complexity: O(m*n)
//Code run successfully on LeetCode.

public class Problem1_BFS {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image == null || image.length ==0 || image[sr][sc] == color)
            return image;
        
        int m = image.length;
        int n = image[0].length;
        
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        int old = image[sr][sc];
        q.add(new int[] {sr,sc});
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = color;
            
            for(int[] dir : dirs){
                
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                
                if(nr >=0 && nr < m && nc >=0 && nc < n && image[nr][nc] == old)
                    q.add(new int[] {nr,nc});
            } 
        }
        
        return image;
    }
}
