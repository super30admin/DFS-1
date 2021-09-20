// TIME: O(M * N)
// SPACE: O(M * N)
// SUCCESS on LeetCode

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // using bfs
        if (newColor == image[sr][sc]) return image;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        
        int value = image[sr][sc];
        
        queue.add(new Pair(sr,sc));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                int r = pair.getKey();
                int c = pair.getValue();
                
                image[r][c] = newColor;
                
                if (r+1 < image.length && image[r+1][c] == value) {
                    queue.add(new Pair(r+1,c));
                }
                if (r-1 >= 0 && image[r-1][c] == value) {
                    queue.add(new Pair(r-1,c));
                }
                if (c+1 < image[0].length && image[r][c+1] == value) {
                    queue.add(new Pair(r,c+1));
                }
                if (c-1 >= 0 && image[r][c-1] == value) {
                    queue.add(new Pair(r,c-1));
                }
            }
        }
        
        return image;
    }
}
