//TC: O(mn)
//SC: O(mn)
class Solution {
    int[][] directions = new int[][]{{-1,0}, {0,1}, {0,-1}, {1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for(int i=0 ; i< m ; i++) {
            for(int j =0; j<n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new ArrayList<>(Arrays.asList(i,j)));
                }
                else if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
                ArrayList<Integer> idx = q.remove();
                for(int[] dir: directions) {
                    int r = idx.get(0) + dir[0];
                    int c = idx.get(1) + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
                        mat[r][c] = mat[idx.get(0)][idx.get(1)]+1;
                        q.add(new ArrayList<>(Arrays.asList(r,c)));
                    }
                }
        }
        return mat;
    }
}