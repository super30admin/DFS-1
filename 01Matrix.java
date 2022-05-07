/*
time - O(m*n)
space - O(m*n)
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0) return mat;
        Queue<int[]> q = new LinkedList<>();
        int n = mat.length, m = mat[0].length;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r>=0 && c>=0 && r<n && c<m && mat[r][c]==-1){
                        q.add(new int[]{r, c});
                        mat[r][c] = dist;
                    }
                }
            }
            dist++;
        }

        return mat;
    }
}