// Time Complexity : O(mn) size of the grid
// Space Complexity : O(mn) size of the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We use the BFS approach, Initially add all the elements with value == 0 in the queue and update the all the
 * 1 if the matrix to -1. Use BFS to traverse all adjacent neighbours of the elements in the queue
 * Check if the value is -1 and update the value to the distance.
 * if it has old color
 * */


import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        //edge
        if(matrix==null || matrix.length==0) return matrix;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    ((LinkedList<int[]>) q).add(new int[]{i,j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        int dist = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c]==-1){
                        matrix[r][c]=dist;
                        ((LinkedList<int[]>) q).add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}
