//Time: O(m*n)
//Space : O(m*n)
//Did it run successfully on leetcode: yes
//Did you face any problem: no
class Matrix {
    public int[][] updateMatrix(int[][] mat) {
        //if input matrix is empty
        if(mat == null || mat.length ==0 || mat[0].length==0) return mat;
        //get row and column length of matrix
        int m = mat.length;
        int n = mat[0].length;
        //Queue for BFS
        Queue<int[]> q = new LinkedList<>();

        //loop through the matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //if 0 found
                if(mat[i][j]==0){
                    //add position to queue
                    q.add(new int[]{i, j});
                }
                //if 0 not found, set position to -1
                else{
                    mat[i][j]=-1;
                }
            }
        }
        //direction array to traverse the neighbors
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0, -1}};
        //distance variable to store distance from zero
        int dist = 1;
        //until our queue is empty
        while(!q.isEmpty()){
            //get current size of queue
            int size = q.size();
            //for all nodes in current level
            for(int i=0;i<size; i++){
                //get curr node
                int[] curr = q.poll();
                //lopping through all neighbors of curr node
                for(int[] dir: dirs){
                    //new row and colum
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    // if row and column are within the bounds and current neighbor is -1 i.e. not visited
                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c]==-1){
                        //update distance of current neighbor from zero
                        mat[r][c] = dist;
                        //add current neighbor to queue
                        q.add(new int[]{r,c});
                    }
                }
            }
            //update distance
            dist++;
        }
        return mat;
    }
}