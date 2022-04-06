// Time Complexity : O(mxn) dimensions of the matrix
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {

    //BFS approach
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image == null)
            return image;

        int m = image.length;
        int n = image[0].length;

        //source cell is alredy new color
        if(image[sr][sc] == newColor)
            return image;

        //store source cell's original color to check neighbors
        int color = image[sr][sc];

        //instead of storing pair of ints, store i and j one after the other
        Queue<Integer> q = new LinkedList();

        //add source cell to queue and make it newColor
        q.add(sr);
        q.add(sc);

        image[sr][sc] = newColor;

        //for movement in matrix
        int[][] directions = new int[][] {
            {-1,0},{1,0},{0,-1},{0,1}
        };


        while(!q.isEmpty())
        {
            //remove current cell from row
            int cr = q.remove();
            int cc = q.remove();

            //iterate over children
            for(int[] d : directions)
            {
                //coordinates of a neighbor
                int nr = d[0] + cr;
                int nc = d[1] + cc;

                //check bounds
                if(nr >=0 && nc >=0 && nr < m && nc < n && image[nr][nc] == color)
                {
                    image[nr][nc] = newColor;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }

        return image;

    }
}
