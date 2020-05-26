/* BFS Solution
Time Complexity: O(M*N)
Space Complexity: O(M*N)
class Solution {



    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {



        if(image[sr][sc] == newColor) return image;



        if(image == null || image.length == 0) return image;



        Queue <int[]> q = new LinkedList <>();



        int color = image[sr][sc];



        q.add(new int [] {sr, sc});



        image[sr][sc] = newColor;



        int [][] dirs = new int [][]{{0,1},{1,0}, {-1,0},{0,-1}};



        while(!q.isEmpty()){



            int [] curr = q.poll();



            for(int [] dir : dirs){



                int i = dir[0] + curr[0];



                int j = dir[1] + curr[1];



                if(i>= 0 && i < image.length &&



                   j >=0 && j < image[0].length



                   && image[i][j] == color



                  ) {



                    q.add(new int[] {i,j});



                    image[i][j] = newColor;



                    }  



            }



        }



        return image;



    }



}
*/


/*DFS Solution 
Time Complexity: O(M*N)
Space Complexity: O(M*N)
*/
class Solution {
    int color;
    int [][] dirs ={{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        color = image[sr][sc];
        if(image == null || image.length ==0 || color == newColor)
            return image;
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor)
    {
        //base
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length ||
          image[sr][sc] != color)
            return;
        //logic 
        image[sr][sc] = newColor;
        for(int[] dir: dirs)
        {
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image, r, c, newColor);
        }
    }
}