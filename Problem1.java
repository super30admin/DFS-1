// BFS Solution
// Time Complexity - O(mn) where m is the number of rows and n is the number of columns in image matrix
// Space Complexity - O(mn) where m is the number of rows and n is the number of columns in image matrix
// This Solution worked on LeetCode

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
            int[] curr = q.poll();
            int r= 0;
            int c= 0;
            for(int[] dir : dirs){
                r = curr[0] + dir[0];
                c = curr[1] + dir[1];
                if(r < m && r>=0 && c < n && c >= 0 && image[r][c] == color){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}
