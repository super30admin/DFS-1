// Time - O(MN)
// Space - O(MN)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new int[][] {{}};
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<matrix.length;i++) {
            for(int j =0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    q.add(new int[] {i,j});
                }      
                else {
                    matrix[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] el = q.poll();
                for(int[] dir : dirs) {
                    int r = el[0] + dir[0];
                    int c = el[1] + dir[1];
                    
                    if(r>=0 && r < matrix.length && c >=0 && c < matrix[0].length && matrix[r][c] == -1) {
                        matrix[r][c] = level;
                        q.add(new int[] {r,c});
                    }
                }
            }
            level++;
        }
        
        return matrix;
    }
}
