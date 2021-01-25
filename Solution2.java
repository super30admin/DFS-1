package dfs1;
//Time Complexity:O(mn)
//Space Complexity:)=O(mn)


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
       if(matrix.length == 0 || matrix == null)return matrix;
        Queue<int[] > que= new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    que.add(new int[]{i,j});
                }
                else{
                    matrix[i][j] = -1; // turning all the 1's to -1;
                }
            }
        }
        int dirs[][] = {{0,-1},{0,1},{-1,0},{1,0}};  //dirs array for traversing four directions
        int dist = 1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                 int []curr = que.poll();
                for(int[]dir:dirs){
                    int r = dir[0] + curr[0];
                    int c = curr[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n &&matrix[r][c] == -1){
                        matrix[r][c] = dist;
                        que.add(new int[]{r,c});
                    }
                }
            }dist++;
        }return matrix;
    }
}
