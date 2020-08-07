//Time complexity:O(m*n)
//Space Complexity:O(m*n)
/*Approach
-taking bfs approach,and taking all zeros as starting point for bfs ,because they are independent
-in place of 1s keeping -1 so that the value itself can be separated from distance from 0s
-then processing level by level and incrementing the distance of it by 1 of its previous
*/
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix{
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix ==  null || matrix.length == 0){return matrix;}
        Queue<int[]> q = new LinkedList<>();
        for(int i  = 0;i < matrix.length; i++){
            for(int j = 0;j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[][] dirs  = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
           int curr[] = q.poll();
            for(int dir[] : dirs){
                int r  = curr[0] + dir[0];
                int c  = curr[1] + dir[1];
                if(r>=0 && r <matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] == -1){
                    matrix[r][c] = matrix[curr[0]][curr[1]]+1;
                    q.add(new int[]{r,c});

                }
            }
        }
       return matrix; 
    }
    public static void main(String[] args) {
       ZeroOneMatrix obj = new ZeroOneMatrix();
       int[][] result = obj.updateMatrix(new int[][]{{0,0,0},
        {0,1,0},
        {1,1,1}
       });
       for(int i  = 0;i < result.length; i++){
        for(int j = 0;j < result[0].length ; j++){
            System.out.print(result[i][j] + " ");
        }
        System.out.println();
       }
    }
}