//BFS 
// All nodes
// Time complexity = O(m*n)
// Space complexity = O(m*n)
// Used a queue to store all the child nodes and then pop it out.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image== null) return image;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        // {(row), {column}} <- queue.
        Queue<Integer>q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        int startColor = image[sr][sc];
        
        if(color == startColor) return image;
        while(!q.isEmpty()) {
            int row = q.poll();
            int col = q.poll();
            image[row][col] = color;
            for(int[] dir: dirs) {
                int r = row+ dir[0];
                int c = col+ dir[1];
                if(r>=0 && r< image.length && c>=0 && c< image[0].length) {
                  if(image[r][c]== startColor) {
                      q.add(r);
                      q.add(c);
                  }
                }
            }
        }
        return image;
    }
}