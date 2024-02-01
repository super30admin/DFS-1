//Accepted on LT
//The idea is similar do bfs 
class Solution {
    int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        Queue<int []> q = new LinkedList<>();
        for(int i =0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    int[] l = new int[2];
                    l[0]=i;
                    l[1]=j;
                    
                    q.add(l);

                }
            }
        }
        while(!q.isEmpty()){
            int[] cr = q.poll();
            for(int[] item : d){
                int x = item[0]+cr[0];
                int y = item[1]+cr[1];
                if(x<0||x>=mat.length||y<0 || y>=mat[0].length) continue;
                if(mat[x][y]==1){
                    mat[x][y] = mat[cr[0]][cr[1]]-1;
                    int[] l = new int[2];
                    l[0]=x;
                    l[1]=y;
                    q.add(l);
                }
            }
        }
         for(int i =0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j]= -1*mat[i][j];
            }
        }
        return mat;
    }
}