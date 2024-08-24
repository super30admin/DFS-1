//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null)return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int curr = image[sr][sc];
        image[sr][sc] = color;
        if(curr == color) {
            return image;
        }
        while(!q.isEmpty()){
            int[] curVal = q.poll();
            for(int[] dir : dirs){
                int cr = curVal[0] + dir[0]; // 1 + 0
                int cc = curVal[1] + dir[1]; // 1+1
                if(cr>=0 && cc>=0 && cr < image.length && cc<image[0].length){
                    if(image[cr][cc]==curr){
                        q.add(new int[]{cr,cc});
                        image[cr][cc] = color;
                    }
                }
            }
        }
        return image;
    }
}
