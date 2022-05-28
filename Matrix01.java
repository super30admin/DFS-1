// Time Complexity : O(N), N = m*n
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Matrix01 {
    private int[][] output;
    private int[][] dirs;
    private int m;
    private int n;
    public int[][] updateMatrix(int[][] mat) {
        int[][] output = mat;
        int m = mat.length;
        int n =mat[0].length;
        dirs = new int[][]{{0,-1}, {-1,0}, {0,+1}, {+1,0}};
        Queue<int[]> q =  new LinkedList<>();
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(mat[r][c] == 0) {
                    q.add(new int[]{r,c});
                } else if(mat[r][c] == 1) {
                    mat[r][c] = -1;
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty()) {
            int size =  q.size();
            for(int i=0; i< size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c] ==  -1) {
                        q.add(new int[]{r,c});
                        mat[r][c] = mat[curr[0]][curr[1]] +1;
                    }
                }
            }
        }
        return output;
    }
}
