/*
Desc : We consider independent elements i.e; zeroes into the queues, for computational ease the ones are converted to -1,at
every level distance in incremented and the value is replaced in every consecutive level, leaving us with 
Time Complexity : O(mn)
Space Complexity : O(mn)
*/

class Solution {
    int dirs[][] = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0) 
                    q.add(new int[]{i,j});
                else mat[i][j] = -1;
            }
        }
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int [] curr = q.poll();
                for(int dir[] : dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1){
                        mat[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            
            dist++;
        }
        return mat;
    }
}
