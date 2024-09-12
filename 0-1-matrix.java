/**
 * Time: O(m*n) m,n rows and colns of matrix
 * Space: O(m*n) as there might be cases where all the values in the matrix are 0
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)return matrix;
        Queue<int[]> q = new LinkedList<int[]>();
        int dist = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0)
                    q.offer(new int[]{i,j});
                else
                    matrix[i][j] = -1;
            }
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                int[] item = q.poll();
                for(int[] dir:dirs){
                    int r = item[0] +dir[0];
                    int c = item[1]+dir[1];
                    if(r>=0 && r<matrix.length&& c>=0 &&
                            c<matrix[0].length && matrix[r][c] == -1){
                        matrix[r][c] = dist;
                        q.offer(new int[]{r,c});
                    }
                }
                size--;
            }
            dist++;
        }
        return matrix;
    }
}