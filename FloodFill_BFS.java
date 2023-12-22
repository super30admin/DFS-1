//T.C O(m*n)
//S.C O(d) //diagonal length of m*n matrix will be queue space
//BFS approach to traverse through each node and change its adjacent colors using direction matrix
import java.util.Queue;
import java.util.LinkedList;

class FloodFill_BFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //if color is same as new, return
        if(image[sr][sc] == newColor) return image;

        //directions matrix
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        int m = image.length, n = image[0].length;

        int oldColor = image[sr][sc];

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{sr,sc});
        image[sr][sc] = newColor;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if(r>=0 && c>=0 && r<m && c<n && image[r][c]==oldColor){
                    image[r][c] = newColor;
                    q.add(new int[]{r,c});
                }
            }
        }

        return image;
    }
}