// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if (startColor == color)
            return image;
        image[sr][sc] = color;
        LinkedList<Integer[]> line = new LinkedList<>();
        int [][]move = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        line.add(new Integer[]{sr, sc});
        Integer []tmp;
        while (line.size() > 0) {
            tmp = line.getFirst();
            line.removeFirst();
            for (int[] step : move) {
                if (tmp[0] + step[0] > -1 && tmp[0] + step[0] < image.length &&
                        tmp[1] + step[1] > -1 && tmp[1] + step[1] < image[0].length &&
                        image[tmp[0] + step[0]][tmp[1] + step[1]] == startColor) {
                    image[tmp[0] + step[0]][tmp[1] + step[1]] = color;

                        line.add(new Integer[]{tmp[0] + step[0], tmp[1] + step[1]});
                }
            }
        }
        return image;
    }
}