// BFS 
// Time complexty = O(m*n)
// Space complexity = O(m*n)
// Start from zero. Put them in the queue. Then when you get 1, mark them as distance from the 0. maintain a distance counter. 
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0},{1,0}, {0,1}, {0,-1}};
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i< m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j]==0) {
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = -1;                    
                }
            }
        }
        while(!q.isEmpty()) {
                int[] node = q.remove();
                int row = node[0] ;
                int col = node[1] ;
                for(int[] dir: dirs) {
                    int r = row+ dir[0];
                    int c = col+ dir[1];
                    if(r>=0 && r< m && c>=0 && c<n  && mat[r][c]==-1)  {
                        q.add(new int[]{r,c});
                        mat[r][c] = mat[row][col]+1;
                    }
                }
                
        }
        return mat;
    }
}