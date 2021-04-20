/**Leetcode Question 733 - Flood Fill */
/**Algo - BFS
 * Approach similar to rotting orange
 */
/**TC - O(M*N)
 * SC - O(M*N)
 */
public class FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if(image == null || image.length==0 || image[sr][sc] ==newColor){
                return image;
            }
            int m = image.length;
            int n = image[0].length;
            Queue<int[]> q = new LinkedList<>();
            int color = image[sr][sc];
            image[sr][sc] = newColor;
            q.add(new int[] {sr,sc});
            int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
            while(!q.isEmpty()){
                int[] curr = q.poll();
                for(int[] dir: directions){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && image[r][c] == color){
                        image[r][c] = newColor;
                        q.add(new int[] {r,c});
                    }
                }
            }
            return image;
        }
    }
}
/**Algo- DFS */
class Solution {
    int m, n,color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length ==0 || image[sr][sc] == newColor){
            return image;
        }
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];
        dfs(image, sr,sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr<0 || sr==m || sc<0 || sc==n || image[sr][sc] != color){
            return;
        }
        
        //logic
        image[sr][sc] = newColor;
        int[][] directions = new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
        for(int[] dir:directions){
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor);
        }
    }
}