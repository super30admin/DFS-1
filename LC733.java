// TC: O(m*n)
// SC: O(m*n)
// where m is the number of rows and n is the number of columns in the matrix


import java.util.LinkedList;
import java.util.Queue;

public class LC733 {
    int x[] = {0,0,1,-1};
    int y[] = {1,-1,0,0};

    class Pair{
        int i, j;
        Pair(int x, int y){
            i=x;
            j=y;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[][] = new int[m][n];

        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                } else {
                    ans[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int currX = p.i;
            int currY = p.j;
            for(int i=0;i<4;i++){
                int newX = currX + x[i];
                int newY = currY + y[i];
                if(newX<0 || newX>=m || newY<0 || newY>=n) continue;
                if(ans[newX][newY]==-1){
                    ans[newX][newY] = ans[currX][currY] + 1 ;
                    q.offer(new Pair(newX, newY));
                }
            }
        }
        return ans;
    }
}
