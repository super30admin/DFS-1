// TimeComplexity: O(m*n)
// SpaceComplexity: O(m*n)
// Explanation: I start by marking all 1s as -1 to indicate unvisited cells and enqueue all 0-cells. 
// Then, I perform BFS layer by layer, updating each neighbor cell with its distance from the nearest 0. 
// I increase the distance after each BFS layer to ensure all cells get the minimum distance from a 0. 
// This guarantees every cell is updated once and efficiently.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Integer> q = new LinkedList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i =0;  i<m ; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1){
                    mat[i][j] = -1;
                }
                if(mat[i][j] == 0) {
                    q.add(i);
                    q.add(j);
                }
            }
        }
        int dist =1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i=i+2) {
                int r= q.poll();
                int c = q.poll();
                for(int[] dir : dirs ){
                    int nr = r+dir[0];
                    int nc = c+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n){
                        if(mat[nr][nc] == -1){
                            mat[nr][nc] = dist;
                            q.add(nr);
                            q.add(nc);
                        }
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
