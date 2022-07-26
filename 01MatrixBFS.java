//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
//Intuit Interview
//BFS:Condisering the level and distance for each node then add the zero value elements to queue size then check the distance if its -1 then add to the queue by taking out the element and then check for distance 2 also for 4 directions.
//BF:add the one element +level and distance for each element for checking.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
     if(mat == null || mat.length == 0) return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs ={{-1,0},{1,0},{0,-1},{0,1}};//UDLR
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j});
                } else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = -1;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir:dirs){
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == -1){
                    q.add(new int[] {nr,nc});
                    mat[nr][nc] = mat[curr[0]][curr[1]]+1;
                }
            }
          
        }
          return mat;
    }
}