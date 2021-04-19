// Time Complexity : O(mn) where m is no. of rows and n is no. of columns
// Space Complexity : O(mn) for queue ; where m is no. of rows and n is no. of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class ZeroOnematrix {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        
        Queue<int[]> q = new LinkedList();
        for(int i=0; i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0) q.offer(new int[]{i,j});
                else matrix[i][j] = -1;
            }
        }
        
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                int x = cur[0] , y = cur[1];
                for(int[] d  :dir){
                    int a = x + d[0] , b = y + d[1];
                    if(a>=0 && a<matrix.length && b>=0 && b<matrix[0].length && matrix[a][b] == -1){
                        matrix[a][b] = level;        
                        q.offer(new int[]{a,b});
                    }
                }
            }
        }
        return matrix;
    }
}