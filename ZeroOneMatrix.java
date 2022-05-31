// Time Complexity : BFS (O(mxn)), DFS (O(m^2 x n^2))
// Space Complexity : BFS (O(mxn), DFS(O(m^2 x n^2)))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Base case, if the given cell is already filled with new colour, return image as it is


// Your code here along with comments explaining your approach
/*
BFS: while queue is not empty, keep on adding the elements that are of old colour that are in the 4 directions and while polling, change the colour to a new colour.
DFS: Run DFS on the source and again run on the elements that are in the 4 directions, base case for recursion would be if the color of the element is not ol coolour.
 */

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    //BFS
    int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        dirs = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> pq = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    pq.add(new int[]{i,j});
                }else if(mat[i][j] == 1){
                    mat[i][j] = -1;
                }
            }
        }

        int size = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r<m && r>=0 && c<n && c>=0 && mat[r][c] == -1){
                    pq.add(new int[]{r,c});
                    mat[r][c] = mat[curr[0]][curr[1]]+1;
                }
            }
        }
        return mat;
    }
}
