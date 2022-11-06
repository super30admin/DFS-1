class Pair{
int row, col;
Pair(int row,int col){
    this.row =row;
    this.col = col;
}}
class Solution {
    int[][] d ={{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int k = mat.length;
        int l = mat[0].length;
        for(int i = 0; i < k; ++i){
          for(int j=0;j<l;++j){
              if(mat[i][j] == 0){
                  q.add(new Pair(i,j));
              }else{
                  mat[i][j]=-1;
              }
          }
        }
        while(!q.isEmpty()){
            Pair p = q.remove();

            for(int[]x :d){
               int r = x[0]+p.row;
               int c = x[1]+p.col;
           if(r>=0 && r<k && c>=0 && c<l && mat[r][c] == -1){
               mat[r][c] = mat[p.row][p.col] +1;
               q.add(new Pair(r,c));
           }
        }}
        return mat;
    }}
        
   //tc=O(mn)
   //sc=O(mn)
