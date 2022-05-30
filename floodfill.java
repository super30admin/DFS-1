// Time Complexity : O(mn) m rows and n columns
// Space Complexity : O(max(m,n) 
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no

//if the starting index colour is new color then return
//else note the pixelcolor of it into color. and start traversing through 4 directions and change the color of all the pixels
if its color is pixelcolor to newcolor.store the row and coloum indices in seperate queues and return if both of them are empty



class Solution {
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        if(image[sr][sc]==newColor) return image;
        Queue<Integer>r = new LinkedList<>();
        Queue<Integer>c = new LinkedList<>();
        r.add(sr);
        c.add(sc);
        int color = image[sr][sc];
        image[sr][sc]= newColor;
        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        while(!r.isEmpty() && !c.isEmpty()){
            int curi = r.poll();
            int curj = c.poll();
            for(int [] dir : dirs){
                 int i = curi + dir[0];
                 int j = curj + dir[1];
                if(i>=0 && i<m && j>=0 && j<n)
                {
                    if(image[i][j] == color){
                    r.add(i);
                    c.add(j);
                    image[i][j] = newColor;
                    }
                }
                
            }

        }
        return image;
    }
}