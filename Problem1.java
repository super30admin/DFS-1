// Time Complexity :O(m*n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n= mat[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }

        int dist =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                for(int[] dir: dirs){
                    int r=dir[0]+cur[0];
                    int c=dir[1]+cur[1];

                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1){
                        mat[r][c]=dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return mat;
    }

}
