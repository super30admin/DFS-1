/*
This solution uses a BFS approach to solve the problem. We first record the color which the new color is going to
replace in the image, and then traverse the image changing only the original color to the new color.

Did this code run on leetcode: Yes
*/
class Solution {
    int[][] dirs;
    int m;
    int n;
    //Time Complexity = O(m*n)
    //Space Complexity = O(m*n)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        //If new color = old color we return the image
        if(image == null || image.length == 0 || color == image[sr][sc])
            return image;
        
        dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        m = image.length;
        n = image[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        //We record the current color so that we can track it in the image
        int currColor = image[sr][sc];
        q.add(new int[]{sr,sc});
        
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = color;
            
            for(int[] dir: dirs)
            {
                int i = curr[0] + dir[0];
                int j = curr[1] + dir[1];
                
                if(i >= 0 && j >= 0 && i < m && j < n && image[i][j] == currColor)
                    q.add(new int[]{i,j});
            }
            
        }
        
        return image;
        
    }
}