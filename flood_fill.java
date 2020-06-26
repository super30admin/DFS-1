/**
 * BFS: O(m*n) m,n rows and col of the image
 * space: O(max(m,n))
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 ||
                (sr>=0 && sr<image.length && sc>=0 && sc < image[0].length) && newColor == image[sr][sc])
            return image;

        Queue<int[]> q = new LinkedList<int[]>();
        int oldcolor = image[sr][sc];
        image[sr][sc] = newColor;
        q.offer(new int[]{sr,sc});
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                int[] item = q.poll();
                for(int[]dir :dirs){
                    int r = item[0]+dir[0];
                    int c = item[1]+dir[1];
                    if(r>=0 && c>= 0 && r<image.length && c<image[0].length && image[r][c] == oldcolor){
                        image[r][c] = newColor;
                        q.offer(new int[]{r,c});
                    }
                }
                size--;
            }
        }
        return image;
    }
}