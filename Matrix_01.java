
// TC : O(mn)
// SC : O(mn)

package S30_Codes.DFS_1;
import java.util.LinkedList;
import java.util.Queue;

class Matrix_01 {
    int[][] directions = {
        { 0,  1},
        { 0, -1},
        {-1,  0},
        { 1,  0}
    };

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        Queue<Pair> queue = new LinkedList();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    queue.add(new Pair(i, j));
                else
                    mat[i][j] = -1;
            }
        }

        while(!queue.isEmpty()){
            Pair p = queue.poll();

            for(int[] dir : directions){
                int nextI = dir[0] + p.row;
                int nextJ = dir[1] + p.col;

                if(nextI>=0 && nextI<m && nextJ>=0 && nextJ<n && mat[nextI][nextJ] == -1){
                    mat[nextI][nextJ] = mat[p.row][p.col] + 1;
                    queue.add(new Pair(nextI, nextJ));
                }
            }
        }

        return mat;
    }
}