import java.util.*;

class FloodFill {

    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        //TC: O(N) - It will traverse all the elements in the worst case.
        //SC: O(N) - All the elements will be inside the queue in the worst case.
        if (image == null || image[0].length == 0 || image[0].length == 0)
            return image;
        int oldColor = image[sr][sc];
        if (oldColor == newColor)
            return image;
        DFS(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void DFS(int[][] image, int sr, int sc, int oldColor, int newColor) {
        int current = image[sr][sc];
        if (current != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, };

        for (int[] dir : dirs) {
            int row = dir[0] + sr;
            int column = dir[1] + sc;
            if (row >= 0 && row < image.length && column >= 0 && column < image[0].length) {
                DFS(image, row, column, oldColor, newColor);
            }
        }
    }

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        //TC: O(N) - It will traverse all the elements in the worst case.
        //SC: O(N) - All the elements will be inside the stack in the worst case.
        if (image == null || image.length == 0 || image[0].length == 0)
            return image;
        int m = image.length;
        int n = image[0].length;

        if (image[sr][sc] == newColor)
            return image;
        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] { sr, sc });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentValue = image[current[0]][current[1]];
            if (currentValue == oldColor) {
                image[current[0]][current[1]] = newColor;
                int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
                for (int[] dir : dirs) {
                    int row = dir[0] + current[0];
                    int column = dir[1] + current[1];
                    if (row >= 0 && row < m && column >= 0 && column < n && image[row][column] == oldColor) {
                        queue.add(new int[] { row, column });
                    }
                }
            }
        }
        return image;
    }

    private int[][] floodFillDFSPractice(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        dfshelper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfshelper(int[][] image, int sr, int sc, int oldColor, int newColor) {

        int[][] dirs = new int[][]{
            {-1,0},
            {0,1},
            {0,-1},
            {1,0},
        };
        image[sr][sc] = newColor;
        for(int[] dir: dirs) {
            int row = dir[0]+sr;
            int column = dir[1]+sc;
            if(row >=0 && row<image.length && column>=0 && column<image[0].length && image[row][column]!=newColor && image[row][column]!=0){
                dfshelper(image, row, column , oldColor, newColor);
            }
        }

    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = new int[][] {
            {6,7,8},
            {9,3,0},
            {4,0,1}
        };
       int[][] finalImage = floodFill.floodFillDFSPractice(image, 1,1,2);
       for(int i=0;i<finalImage.length;i++) {
           StringBuilder builder = new StringBuilder();
           for(int j=0;j<finalImage[0].length;j++) {
            builder.append(finalImage[i][j]);
            builder.append(",");
           }
           System.out.println(builder.toString());
       }

    }
}