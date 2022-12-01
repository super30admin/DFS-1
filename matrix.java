//TC: O(m X n)
//SC: O(m X n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0){
            return mat;
        }

        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; //UDRL

        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    rows.add(i);
                    column.add(j);
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }

        int level = 1;

        while (!rows.isEmpty()){
            int size = column.size();
            for(int i=0; i< size; i++){
                int r = rows.poll();
                int c = column.poll();
            
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                    mat[nr][nc] = level;
                    rows.add(nr);
                    column.add(nc);
                }
            }
            
        }
        level++;
        }
        return mat;
    }
}
