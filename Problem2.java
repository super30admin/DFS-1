package DFS1;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * Initially we find all the zeroes and add them to the queue and then we keep doing BFS (ie keep going to neighbour
 * and then  neighbour's neighbour and so on) to find the neighbouring 1s at each level, add them to queue and update their 
 * distance. In the next level we find neighbours of the 1s added to queue and update their corresponding distance.
 * 
 * Time Complexity : O(mn) where m is no of rows and n is cols
 * 
 * 
 * Space Complexity : O(mn) since we use a queue
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    int[][]dirs= {{1,0},{0,1},{0,-1},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        Queue <int []> q =new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0; j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
            }
            }

            while(!q.isEmpty()){
                int []curr=q.poll();
                for(int i=0;i<dirs.length;i++){
                    int targetRow=curr[0]+dirs[i][0];
                    int targetCol=curr[1]+dirs[i][1];

                    if(targetRow>=0 && targetRow<mat.length && targetCol>=0 && 
                     targetCol < mat[0].length && mat[targetRow][targetCol]==-1){
                         mat[targetRow][targetCol]=mat[curr[0]][curr[1]]+1;
                         q.add(new int[] {targetRow, targetCol});
                     }
               }
            }

            return mat;
    }
}
