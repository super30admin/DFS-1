import java.util.LinkedList;
import java.util.Queue;
//tc = o(m*n)
//sc = o(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int m = image.length;
        int n = image[0].length;
        int oldcolor = image[sr][sc];
        if(oldcolor == color)return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] current = q.remove();
            for(int[] dir:dirs){
                int nr = current[0] + dir[0];
                int nc = current[1] + dir[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldcolor){
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }

            }

        }
        return image;
    }
    
}