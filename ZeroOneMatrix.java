import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    int[][] dirs = new int[][] {{0,1}, {0, -1}, {-1,0}, {1, 0}};
    //TimeComplexity: O(MXN)
    //Space Complexity: O(MXN)
    public int[][] updateMatrixDFS(int[][] mat){


        for(int i = 0 ; i< mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = 9999;
                }

            }
        }

        for(int i = 0 ; i< mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if(mat[i][j] == 0){
                    helper(mat, i, j, 0);
                }

            }
        }
        return mat;
    }

    private void helper(int[][] mat, int i , int j, int level){
        //base
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] < level){
            return;
        }
        //logic
        //System.out.println(i+" "+j+" "+mat[i][j]+" "+ level);
        mat[i][j] = level;
        for(int[] dir: dirs){
            helper(mat, i+ dir[0], j+ dir[1], level + 1);
        }

    }

    //TimeComplexity: O(MXN)
    //Space Complexity: O(MXN)
     public int[][] updateMatrixBFS(int[][] mat) {
         Queue<Integer> queue = new LinkedList<>();

         for(int i = 0 ; i< mat.length; i++){
             for(int j = 0; j< mat[0].length; j++){
                 if(mat[i][j]== 0){
                     queue.offer(i);
                     queue.offer(j);
                 }
                 if(mat[i][j] == 1){
                     mat[i][j] = -1;
                 }

             }
         }

         int level = 1;
         while(!queue.isEmpty()){
             int size = queue.size();

             for(int i = 0; i< size/2; i++){
                 System.out.println(queue+" "+ i);
                 int r = queue.poll();
                 int c = queue.poll();
                 for(int[] dir: dirs){
                     int nr = r + dir[0];
                     int nc = c + dir[1];
                     if(nr >=0 && nr < mat.length && nc >=0 && nc < mat[0].length && mat[nr][nc] == -1){
                         mat[nr][nc] = mat[r][c] + 1;
                         queue.offer(nr);
                         queue.offer(nc);
                     }

                 }
             }
             level ++;

         }

         return mat;

     }
}
