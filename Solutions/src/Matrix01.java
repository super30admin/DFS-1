
class Solution {
    int[] dx ={-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int[][] updateMatrix(int[][] matrix) {

        //base checks
        int m= matrix.length;
        int n = matrix[0].length;


        // results matrix
        int[][] result = new int[m][n];
        Queue<Pair> q =  new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=Integer.MAX_VALUE;
                if(matrix[i][j]==0){
                    result[i][j]=0;
                    q.add(new Pair(i,j));
                }

            }
        }
        while(!q.isEmpty()){
            Pair current  = q.poll();
            for(int i=0;i<4;i++){
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                if(isValid(m,n,x,y)){
                    if(result[current.x][current.y]+1<result[x][y]){
                        result[x][y] =  result[current.x][current.y]+1;
                        q.add(new Pair(x,y));
                    }
                }

            }
        }
        return result;
    }
    private Boolean isValid(int m, int n , int x, int y){
        return x>=0 && y>=0 && x<m && y<n;
    }
}
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
