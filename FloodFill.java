// Time Complexity O(mxn)
// Space Complexity O(mxn)
// Runs on LeetCode YES

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        Queue<Integer> qRow = new LinkedList<Integer>();
        Queue<Integer> qCol = new LinkedList<Integer>();

        int initColor = image[sr][sc];

        if (initColor == color) {
            return image;
        }

        qRow.add(sr);
        qCol.add(sc);
        image[sr][sc] = color;

        while (!qRow.isEmpty()) {
            int row = qRow.poll();
            int col = qCol.poll();

            for (int[] dir : dirs) {
                int curRow = row + dir[0];
                int curCol = col + dir[1];

                if (curRow < image.length && curCol < image[0].length &&
                        curRow >= 0 && curCol >= 0 &&
                        image[curRow][curCol] == initColor) {
                    qRow.add(curRow);
                    qCol.add(curCol);
                    image[curRow][curCol] = color;
                }
            }
        }
        return image;

    }
}