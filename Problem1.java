// Time(mn)
// Space (mn)


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
                    //dfs flood flood
                    if (image[sr][sc] == color) return image;
                    int old_color = image[sr][sc];

                    floodFill(image,sr,sc, old_color, color);
                
        
        return image;
    }

    public void floodFill(int[][] image, int i, int j, int old_color, int color){
        int m = image.length;
        int n = image[0].length;
        if(i<0 || j < 0 || i>=m || j >=n || image[i][j] != old_color)
        {
                return;
        }
            
        image[i][j] = color;
        System.out.println(j);
        floodFill(image,i+1,j,old_color,color);
        floodFill(image,i-1,j,old_color,color);
        floodFill(image,i,j+1,old_color,color);
        floodFill(image,i,j-1,old_color,color);
    }
}
