package DFS-1;

public class problem1 {

// Time Complexity : O(V+E) V are vertices and E are edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) return image;
        
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int oldColor = image[sr][sc];
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int m = image.length;
        int n = image[0].length;
        
        rows.add(sr);
        cols.add(sc);
        image[sr][sc] = color;
        
        while(!rows.isEmpty()){
            int row = rows.poll();
            int col = cols.poll();
            
            for(int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < m && nc >=0 && nc < n && image[nr][nc] == oldColor){
                    image[nr][nc] = color;
                    rows.add(nr);
                    cols.add(nc);
                }
            }
        }
        return image;
        
        
    }
}
