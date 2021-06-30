import java.util.Queue;

/**
 * @author Vishal Puri
 * // Time Complexity : O(m*n)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class UpdateMatrix {
    int[][] res;
    int min=0;
    int m,n;
    int dirs[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null) return mat;
        m=mat.length;
        n=mat[0].length;
        Queue<int []> q = (Queue<int[]>) new LinkedList();
        for(int i = 0; i < m; i++){
            for (int j=0; j<n; j++){
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else
                    mat[i][j]=-1;
            }
        }
        m=mat.length;
        n=mat[0].length;
        int dist=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i < size ; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = dir[0]+curr[0];
                    int nc = dir[1]+curr[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                        q.add(new int[]{nr, nc});
                        mat[nr][nc]=dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
