// Time Complexity :O(mxm) where m and n rows and column length of input matrix
// Space Complexity : O(mxm) where m and n rows and column length of input matrix
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes

import java.util.*;
public class ZeroOneMatrix {
    
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0){
            return mat;
        }
        int row = mat.length, col = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(mat[r][c] == 0){
                    //to perform bsf, add cells which has value 0
                    q.offer(new Pair(r, c));
                }else{
                    //initialize as -1 so that it can be updated later with value greater than 0 to find nearest 0
                    mat[r][c] = -1;
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int dir[] : dirs){
                int x = curr.x + dir[0];
                int y = curr.y + dir[1];
                
                if(x >= row || y >= col || x <0 || y < 0 || mat[x][y] >= 0){
                    continue;
                }
                mat[x][y] = 1 + mat[curr.x][curr.y];
                q.offer(new Pair(x, y));
            }
        }
        return mat;
    }
    class Pair{
        int x,y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
