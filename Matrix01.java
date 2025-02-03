import java.util.LinkedList;
import java.util.Queue;
// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0){
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int lvl = 0;
        int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.add(new int[] {i,j});
                } else {
                    mat[i][j]=-1;
                }
            }
        }
        while(!queue.isEmpty()){
            //int size = queue.size();
            //for(int i=0;i<size;i++){
            int [] curr = queue.poll();
            for(int[] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                    queue.add(new int[] {nr,nc});
                    // mat[nr][nc]=lvl+1;
                    mat[nr][nc] = mat[curr[0]][curr[1]]+1;
                }
            }
            // }
            lvl++;
        }
        return mat;
    }
}