// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int[][] dirs = new int[][]{ new int[]{0,1}, new int[]{1,0}, new int[]{0,-1}, new int[]{-1,0}};
        Queue<int> queue = new Queue<int>();
        int origColor = image[sr][sc];
        int m = image.Length;
        int n = image[0].Length;
        
        queue.Enqueue(sr);
        queue.Enqueue(sc);
        image[sr][sc] = color;
        
        int size = queue.Count;
        while(queue.Count > 0) {
            int cr = queue.Dequeue();
            int cc = queue.Dequeue();

            foreach(int[] dir in dirs) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == origColor) {
                    queue.Enqueue(nr);
                    queue.Enqueue(nc);
                    image[nr][nc] = color;
                }
            }
            size = queue.Count;
        }
        
        return image;
    }
}