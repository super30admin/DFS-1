
import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01 {

	public static void main(String[] args) {
		int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
		Solution4 s = new Solution4();
		System.out.println(s.updateMatrix(mat));
	}

}
class Solution4 {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                if(mat[i][j]==1)
                mat[i][j] = mat[i][j]*-1;
            }
        }

        //bfs
        while(!q.isEmpty()){
            int[] element = q.poll();
            for(int[] dir:directions){
                int nr = dir[0]+element[0];
                int nc = dir[1]+element[1];
                if(nr>=0&& nc>=0 && nr<row && nc<col && mat[nr][nc]==-1){
                    mat[nr][nc] = mat[element[0]][element[1]]+1;
                    q.add(new int[]{nr,nc});
                }                
            }

        }
        return mat;
    }
}