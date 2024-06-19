import java.util.LinkedList;
import java.util.Queue;

/**
    Time Complexiy: O(m*n)
    Space Complexity : O(m*n)

    Make all the 0's as the root and add them into the queue . 
*/

class O1Matrix {
    public int[][] updateMatrix(int[][] mat) {
        if(mat== null || mat.length==0 || mat[0].length==0)
            return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        int [][]dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            } 
        }
        int level = 0;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            for(int[] dir:dirs){
                int nr = dir[0] + pos[0];
                int nc = dir[1] + pos[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]<0){
                    mat[nr][nc] = 1 + mat[pos[0]][pos[1]];
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}