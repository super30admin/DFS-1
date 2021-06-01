//Time : O(m*n), where m = num of rows, n= num of column
//space : O(m*n) for recursion stack
//Did it run successfully on leetcode: yes
//Did you face any problem: no
class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //if image is empty or newColor same as old color
        if(image==null||image.length == 0 || image[0].length==0 || image[sr][sc]==newColor) return image;
        //store old color of starting position
        int oldColor = image[sr][sc];
        //call dfs
        dfs(image, sr, sc, oldColor, newColor);

        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {

        //base
        //if current position doesn't have old color
        if(image[sr][sc] != oldColor) return;
        //logic
        //change color of current position to new color
        image[sr][sc] = newColor;
        //matrix to travers all four direction
        int[][] dirs = new int[][]{ {-1,0}, {0,1}, {1,0}, {0,-1}};
        //looping to all the four neighbors of current position
        for(int[] dir: dirs){
            //nee row
            int r = dir[0] + sr;
            //new collumn
            int c = dir[1] + sc;
            //if row and column within bound
            if(r>=0 && r<image.length && c >=0 && c<image[0].length ){
                //call dfs
                dfs(image, r, c, oldColor, newColor);
            }
        }
    }
}