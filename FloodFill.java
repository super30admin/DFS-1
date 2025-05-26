// Time Complexity : O(m * n) 
// Space Complexity : O(m * n) 

import java.util.*;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {   
        Queue<int[]> q = new LinkedList<>();
        int op = image[sr][sc];
        q.add(new int[]{sr,sc});
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int z=0;z<q.size();z++)
            {
                int[] re = q.poll();
                int i= re[0];
                int j = re[1];
                image[i][j] = -1;
                if (i - 1 >= 0 && image[i - 1][j] == op) {
                    q.add(new int[]{i - 1, j});
                }
                if (i + 1 < image.length && image[i + 1][j] == op) {
                    q.add(new int[]{i + 1, j});
                }
                if (j - 1 >= 0 && image[i][j - 1] == op) {
                    q.add(new int[]{i, j - 1});
                }
                if (j + 1 < image[0].length && image[i][j + 1] == op) {
                    q.add(new int[]{i, j + 1});
                }
            }
        }
        for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[i].length;j++)
            {
                if(image[i][j]==-1)
                {
                    image[i][j] = color;
                }
            }
        }
        return image;
    }
}