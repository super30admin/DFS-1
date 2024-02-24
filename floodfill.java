//TimeComplexity : O(m*n)
//SpaceComplexity: O(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][]dirs = {{0,1},{0,-1}, {1,0}, {-1,0}};
        if(image[sr][sc] == color) {
            return image;
        }
        int original_color = image[sr][sc];
        image[sr][sc] = color;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {sr,sc});
        while(!queue.isEmpty()) {
            int []curr = queue.poll();
            for(int []dir : dirs) {
                int r = dir[0]+curr[0];
                int c = dir[1]+curr[1];
                if(r >=0 && c>=0 && r<image.length && c < image[0].length && image[r][c] == original_color) {
                     image[r][c] = color;
                     queue.add(new int[] {r,c});
                }
            }
        }
        return image;
    }
}