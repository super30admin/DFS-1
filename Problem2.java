package DFS-1;

public class Problem2 {
    int m,n;
    int[][] result;
    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n=mat[0].length;
        this.result=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    result[i][j]=dfs(mat,i,j);
                }
            }
        }
        return result;
    }

    public int dfs(int[][] mat, int i, int j){
        if(i>0&& mat[i-1][j]==0) return 1;
        if(j>0&&mat[i][j-1]==0) return 1;
        if(i<m-1&&mat[i+1][j]==0) return 1;
        if(j<n-1&&mat[i][j+1]==0) return 1;

        int top=9999, left=9999, bottom=9999, right=9999;
        if(i>0&&result[i-1][j]!=0){
            top=result[i-1][j];
        }
        if(j>0&&result[i][j-1]!=0){
            left=result[i][j-1];
        }
        if(i<m-1){
            if(result[i+1][j]==0){
                result[i+1][j]=dfs(mat,i+1,j);
            }
            bottom=result[i+1][j];
        }
        if(j<n-1){
            if(result[i][j+1]==0){
                result[i][j+1]=dfs(mat,i,j+1);
            }
            right=result[i][j+1];
        }

        return 1+Math.min(left,Math.min(right,Math.min(top,bottom)));
    }
}
