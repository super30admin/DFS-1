//TC - O(m*n)
//SC- O(m*n)

public class FloofFillDFS {
    public static void main(String[] args) {
        // Define the input matrix
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1; // Starting row
        int sc = 1; // Starting column
        int newColor = 2; // New color to fill

        FloodFill floodFill = new FloodFill();
        int[][] result = floodFill.floodFill(image, sr, sc, newColor);

        // Print the result
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    int mRows, nCols, originalColor;
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image == null || image.length == 0 || image[sr][sc] == color){
            return image;
        }

        mRows = image.length;
        nCols = image[0].length;
        originalColor = image[sr][sc];
        dirs= new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        dfs(image, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int color){

        if(row < 0 || row == mRows || col < 0 || col == nCols || image[row][col] != originalColor){
            return;
        }

        image[row][col] = color;

        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(image, nr, nc, color);
        }
        
    }

}
