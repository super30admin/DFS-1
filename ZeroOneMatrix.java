
// BFS Optimized
public class ZeroOneMatrix {
        public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length==0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int []> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) q.add(new int[]{i,j});
                else matrix[i][j]=-1;
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir:dirs){
                    int nr = dir[0]+curr[0];
                    int nc = dir[1]+curr[1];
                    
                    if(nr>=0 && nc>=0 && nr<m && nc<n && matrix[nr][nc]==-1){
                        matrix[nr][nc] = matrix[curr[0]][curr[1]]+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return matrix;
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)