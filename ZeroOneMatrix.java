// Time Complexity :O(m*n) where m is number of rows and n is the number of columns in the matrix
// Space Complexity :O(m*n) where m is number of rows and n is the number of columns in the matrix
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    private int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length < 0){
            return mat;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i< mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(i);
                    q.add(j);
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        int distance = 1;

        dirs = new int[][] {{-1, 0}, {1,0}, {0,-1}, {0,1}};

        while(!q.isEmpty()){
            int size = q.size()/2;
            for(int i= 0; i< size; i++){
                int cr = q.poll();
                int cc = q.poll();

                for(int[] dir : dirs){
                    int nr = cr + dir[0];
                    int nc = cc + dir[1];

                    if(nr >=0 && nr < mat.length && nc>=0 && nc < mat[0].length
                            && mat[nr][nc] == -1){
                        mat[nr][nc] = distance;
                        q.add(nr);
                        q.add(nc);
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}
