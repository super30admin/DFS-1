// BFS Solution
// Time Complexity - O(mn) where m is the number of rows and n is the number of columns in image matrix
// Space Complexity - O(mn) where m is the number of rows and n is the number of columns in image matrix
// This Solution worked on LeetCode

// In this problem

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if(image == null || m == 0 || n==0)
            return image;
        int color = image[sr][sc];
        if(image[sr][sc] == newColor)   return image;
        int[][] dirs = {{1,0},{0,1}, {-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
            int[] curr = q.poll();  // poll from the queue and find the neighbouring cells with same original color of the source cell
            int r= 0;
            int c= 0;
            for(int[] dir : dirs){
                r = curr[0] + dir[0];
                c = curr[1] + dir[1];
                if(r < m && r>=0 && c < n && c >= 0 && image[r][c] == color){ // check if the new r and c are valid
                    image[r][c] = newColor;     // fill the cell with newColor and add this to the queue. to find it's neighboring cell 
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;   // return the image with newColor filled from the source cell
    }
}

// DFS Solution
// Time Complexity - O(mn)
// Space Complexity - O(1) if we do not consider the recursive stack memory space

class Solution {
    int color = -1;
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if(image == null || m == 0 || n==0)
            return image;
        if(image[sr][sc] == newColor)   return image;
        color = image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    private void dfs(int[][] image,int r,int c, int newColor){
        // Base Case
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color)                        return;
        // Logic
        image[r][c] = newColor;
        int i=0;
        int j=0;
        for(int[] dir : dirs){
            i = r + dir[0];
            j = c + dir[1];
            dfs(image,i,j,newColor);
        }  
    }
}
