// tc = O (m*n)
// Sc = O(m*n)

public class FoodFill {

    public static void main(String[] args) {
        int[][] m = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        FoodFill obj = new FoodFill();
        int[][] obj1 = obj.floodFill(m, 0, 0, 0);

        // Print the updated image
        for (int[] row : obj1) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // null check
        if (image == null || image.length == 0)
            return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        // image [sr][sc] = color;
        int org = image[sr][sc];
        if (image[sr][sc] == color)
            return image;
        dfs(image, sr, sc, color, dirs, m, n, org);
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int color, int[][] dirs, int m, int n, int org) {
        // base
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != org)
            return;

        // logic
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            // image[nr][nc] = color;

            dfs(image, nr, nc, color, dirs, m, n, org);

        }

    }

}