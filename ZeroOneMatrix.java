//BFS
//TimeComplexity:O(M*N)
//Space Complexity:O(M*N) Recursive Stack
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0) {
                    queue.add(new Pair(i,j));
                }
                if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            for(int i=0;i<directions.length;i++){
                int x= directions[i][0] + current.x;
                int y= directions[i][1] + current.y;

                if(x>=0 && x<mat.length && y>=0 && y<mat[0].length && mat[x][y] == -1){
                    mat[x][y]=mat[current.x][current.y] + 1;
                    queue.add(new Pair(x,y));
                }
            }
        }
        return mat;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}