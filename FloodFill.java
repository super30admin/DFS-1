//BFS
//TC: O(M*N) M - number of rows, N - number of cols
//SC: O(M+N) 

//Approach 1 is BFS. We add the positions of pixels, with same color as (sr,sc) into queue. 
//Change the color of every pixel visited to newColor. Continue the process until queue is empty

import java.util.*;
public class FloodFill {
  
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int color = image[sr][sc];
        
        if(color == newColor) return image;
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        
        //directions array - bfs
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int[] dir : direction){
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                
                if(row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == color){
                    image[row][col] = newColor;
                    q.add(new int[]{row, col});
                }
            }
        }
        return image;
    }

    public static void main(String[] args){
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] res = floodFill(image, 1, 1, 2);

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j <res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
