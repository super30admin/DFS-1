//Time - O(mn)
// Space - O(mn)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int m = mat.length;
        int n=mat[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair<Integer,Integer>(i,j));
                    visited[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair<Integer,Integer> p =q.poll();
            int r = p.getKey();
            int c = p.getValue();
            for(int[] dir: dirs){
                int row = dir[0]+r;
                int col = dir[1]+c;
                if(row>=0 && row<m && col>=0 && col<n && !visited[row][col] && mat[row][col]!=0){
                    mat[row][col]= mat[r][c] + 1;
                    visited[row][col] = true;
                    q.add(new Pair<Integer,Integer>(row,col));
                }
            }
        }
        return mat;
        
    }
}
