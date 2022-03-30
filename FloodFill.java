//Time Complexity O(n)
//Space Complexity O(n)
//Leetcode tested

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static int[][] floodFill(int[][] mat, int sr, int sc, int newColor) {
        Queue<int []> queue =new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int[][] dirs={
                {0,1},
                {-1,0},
                {1,0},
                {0,-1}
        };

        int target= mat[sr][sc];
        if(target == newColor) return mat;
        if(sr>0 || sc>0 || sr<mat.length || sc<mat[0].length){
            mat[sr][sc]=newColor;
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size --> 0){
                int[] cell= queue.poll();
                for (int[] dir:dirs) {
                    int r=cell[0]+dir[0];
                    int c=cell[1]+dir[1];
                    if(r<0 || c<0 || r==mat.length || c==mat[0].length || mat[r][c] != target)
                        continue;
                    mat[r][c]=newColor;
                    queue.add(new int[]{r,c});
                }
            }
        }
        return mat;
    }
}
