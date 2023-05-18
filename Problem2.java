// time: O(mn)
// O(mn)
// BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j =0 ;j< n; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1 ; // to keep track to not visit previous elements again
                }
                
            }
        }
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i = 0;i< size; i++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r>=0 && c >=0 && r< m && c<n && mat[r][c]==-1){
                        q.add(new int[]{r,c});
                        mat[r][c]= dist;
                    }
                }
            }
        }

        return mat;
        
    }
}