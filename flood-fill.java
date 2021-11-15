//Time Complexity:(m*n), in worst casse if all the elements can be accessed because they are all old color
//Space Complexity:(m*n), although not all elements are in queue at the same time but asymtotically its m*n
//running on leetcode: yes
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image==null || image.length==0 || image[sr][sc]==newColor)
        {
            return image;
        }
        int m=image.length;
        int n=image[0].length;
        //to capture old color
        int color=image[sr][sc];
        int[][] dirs  = {{0,1},{1,0}, {-1,0}, {0,-1}};
        //BFS
        //elements of the queue are the coordinates of the color
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        //changing the color of the starting row and col to new color
        image[sr][sc]=newColor;
        
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for (int[] dir : dirs)
            {
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if ( r>=0 && r<m && c>=0 && c<n && image[r][c]==color)
                {
                    q.add(new int[] {r, c});
                    image[r][c]=newColor;
                }
            }
        }
        return image;
    }
}
