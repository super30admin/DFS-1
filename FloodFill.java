//T.C O(m*n)
//S.C O(D) where D is the length of the diagonal of the matrix 
//DFS
class FloodFill {
    int dirs[][] = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    int oldColor, newColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        oldColor = image[sr][sc];
        newColor = color;
        if(oldColor == newColor) return image;

        helper(image, sr, sc);
        return image;
    }

    private void helper(int[][] image, int sr, int sc){
        //base
        //check array boundaries and if color is already changed,do nothing and return
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length||image[sr][sc]!=oldColor)
            return;


        //logic
        image[sr][sc] = newColor;
        //change color using dir matrix
        for(int[] dir: dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            helper(image, r , c);
        }


    }
}
