class Solution {
    //BFS appraoch
    //we store all 0 occurances in queue while marking 1 with -1 cuz we know that matrix contains only 1 and 0
    //-1 indicates that the node isn't visited we change the value of -1 to value of BFS 'level' we are in
    //once we update the -1 with level we put that into our queue to process other unvisited nodes
    // here we are making use of how level can be used brilliantly to keep track of 'far' the 1 is from the zeros
    // ofc we increment level at end of every BFS iteration ie. when we are done processing nearest child node
    // sc: o(m * n) tc: o(m * n)
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) {
            return mat;
        }
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
                        mat[r][c] = dist;
                        q.add(new int[] {r, c});
                    }
                }
            }
            dist++;
        }
        return mat;
     }
}