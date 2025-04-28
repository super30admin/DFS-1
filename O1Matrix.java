import java.util.LinkedList;
import java.util.Queue;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
This code solves the "01 Matrix" problem using a Breadth-First Search (BFS) approach.
It first enqueues all cells with a value of 0 and marks all 1s as -1 to indicate
they are unprocessed. Then, it processes each cell from the queue and updates neighboring
-1 cells with their distance from the nearest 0, level by level.
The BFS ensures that each cell gets the minimum distance value efficiently.
 Finally, the updated matrix with all minimum distances is returned.
* */

public class O1Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m=mat.length;
        int n=mat[0].length;

        Queue<int[]> queue=new LinkedList<int[]>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.add(new int[]{i,j});
                }
                else
                    mat[i][j]=-1;
            }
        }


        while(!queue.isEmpty())
        {

            int[] curr=queue.poll();
            for(int[] dir:dirs)
            {
                int r=dir[0]+curr[0];
                int c=dir[1] + curr[1];
                if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1)
                {
                    queue.add(new int[]{r,c});
                    mat[r][c]=mat[curr[0]][curr[1]]+1;
                }
            }
        }
        return mat;
    }
}
