//Time Complexity : O(mxn)
//Space Complexity : O(mxn) stack space

class Solution {
    int old_color;
    int m , n ;
    int[][] dirs ; 
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) return image ; 
        
        m = image.length ; 
        n = image[0].length ; 
        dirs = new int[][] {{-1,0}, {0,-1} , {1,0} , {0,1}}; //Up left down right 
        old_color = image[sr][sc] ; 
        dfs(image,sr, sc ,color) ; 
        return image ; 
    }

    public void dfs(int[][] image ,int sr, int sc,int color){

        //base condition
        if(sr <0 || sc<0 || sr == m || sc == n||image[sr][sc] != old_color ) return ; 

        //logic
        image[sr][sc] = color ; 
        for(int[]i : dirs){
            int n_row = sr + i[0] ; 
            int n_col = sc + i[1] ; 
            dfs(image , n_row , n_col , color) ; 
        }
    }
}
