// Time Complexity :
//      n is the number of nodes in tree
//      floodFill() - O(n)
//      
// Space Complexity :
//      floodFill() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// DFS

class Solution {
    int clr = 0;
    int newClr = 0;
    int[][] dirs = new int [][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        clr = image[sr][sc];
        newClr = newColor;
        
        dfs(image, sr, sc);
        
        return image;
    }
    
    private void dfs(int[][] image, int r, int c)
    {
        if(r < 0 || r > image.length - 1 || c < 0 || c > image[0].length -  1 || image[r][c] != clr)
            return;
        
        image[r][c] = newClr;
        
        for(int[] dir : dirs)
        {
            dfs(image, r + dir[0], c + dir[1]);
        }
    }
}


// Time Complexity :
//      n is the number of nodes in tree
//      floodFill() - O(n)
//      
// Space Complexity :
//      floodFill() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// BFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        int m = image.length;
        int n = image[0].length;
        
        int[][] dirs = new int [][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        
        int clr = image[sr][sc];
        
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{sr,sc});
        
        image[sr][sc] = newColor;
        
        while(!qu.isEmpty())
        {
            int[] loc = qu.poll();
            
            for(int[] dir: dirs)
            {
                int r = loc[0] + dir[0];
                int c = loc[1] + dir[1];
                
                if(r >=0 && r < m && c >= 0 && c < n && image[r][c] == clr)
                {
                    qu.add(new int[]{r,c});
                    image[r][c] = newColor;
                }
            }
        }
        
        return image;
    }
}
