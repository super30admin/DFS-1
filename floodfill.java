package trees;

import java.util.LinkedList;
import java.util.Queue;

public class floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        int oldcolor= image[sr][sc];
        image[sr][sc]=newColor;
        int m=image.length;
        int n= image[0].length;
        Queue<int[]> que= new LinkedList<>();
        que.add(new int[]{sr,sc});
          int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!que.isEmpty()){
            int[] rowcol= que.poll();
            int cr=rowcol[0];
            int cc=rowcol[1];
            
            //dir array
            for(int[] dir:directions){
                int nr=cr+dir[0];
                int nc=cc+dir[1];
                //inbounds check
                if(nr>=0 && nc >=0 && nr<m && nc<n && image[nr][nc] ==oldcolor){
                    image[nr][nc]=newColor;
                    que.add(new int[]{nr,nc});
                }
            }
        }
        
       return image; 
    }

}
//t=O(mn)
//s=O(mn)