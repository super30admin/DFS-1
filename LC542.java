// TC: O(N*M)
// SC: O(N*M), recursive stack
// where N is the number of rows and M is the number of columns in the image matrix

public class LC542 {
    int s1[]=new int[]{0,0,1,-1};
    int s2[]=new int[]{1,-1,0,0};

    public void fill(int[][] image, int i, int j, int val, int color) {
        image[i][j] = color;
        int N = image.length, M = image[0].length;
        for (int ind = 0; ind < 4; ind++) {
            int x = i + s1[ind], y = j + s2[ind];
            if (x >= 0 && x < N && y >= 0 && y < M && image[x][y] == val && image[x][y] != color) {
                fill(image, x, y, val, color);
            }
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color!=image[sr][sc]) fill(image,sr,sc,image[sr][sc],color);
        return image;
    }
}
