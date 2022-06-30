// Time Complexity : O(m*n) where m*n is the size of grid
// Space Complexity : O(m*n) where m*n is the size of image
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Matrix1 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int rows = mat.length;
        int cols = mat[0].length;
        //int[][] distance = new int[rows][cols];
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int [] curr = q.poll();
                for(int [] dir : dirs){
                    int r = dir[0]+curr[0];
                    int c = dir[1]+curr[1];

                    //bound check
                    if(r>=0 && c>=0 && r<rows && c<cols && mat[r][c]==-1){
                        mat[r][c]=dist+1;
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }

        return mat;
    }

    public static void main(String[] args){
        Matrix1 m = new Matrix1();
        int [][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(m.updateMatrix(image)));
    }
}