import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * DFS Time Complexity : O(m*n)
 * DFS Space Complexity : O(m*n)
 * 
 * BFS Time Complexity : O(m*n)
 * BFS Space Complexity : O(m*n)
 * 
 */
public class FloodFill {

    //DFS Implementation
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image== null || image.length==0 || image[sr][sc]==color)
            return image;
        int intialColor = image[sr][sc];
        floodFill(image, sr, sc, color, intialColor);
        return image;
    }

    //DFS Implementation
    private void floodFill(int[][]image, int sr, int sc, int color, int initalColor){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=initalColor)
            return;
        if(image[sr][sc] == initalColor){
            image[sr][sc] = color;
            floodFill(image, sr+1,sc,color,initalColor);
            floodFill(image, sr-1,sc,color,initalColor);
            floodFill(image, sr,sc+1,color,initalColor);
            floodFill(image, sr,sc-1,color,initalColor);
        }
    }


    // BFS Implementation
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        
        if(image == null || image.length==0 || image[sr][sc]==color)
            return image;
        Queue<Integer> iQ = new LinkedList();
        Queue<Integer> jQ = new LinkedList();
        int initalColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        iQ.add(sr);
        jQ.add(sc);
        image[sr][sc] = color;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!iQ.isEmpty()){
            int or = iQ.poll();
            int oc = jQ.poll();
            for(int[] dir:dirs){
                int nr = dir[0]+or;
                int nc = dir[1]+oc;
                if(nr>=0 &&nr<m && nc>=0 && nc<n && image[nr][nc] == initalColor){
                    iQ.add(nr);
                    jQ.add(nc);
                    image[nr][nc] = color;
                }
            }        
        }
        return image;
    }
}
