/*
time complexity : O(m * n)
space complexity : O(m * n)
*/
class Solution {
    int[][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0){
            return matrix;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m;i++){
            for(int j =0 ;j < n;j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i,j});    
                }
                else{
                    matrix[i][j] = -1;
                }   
            }
        }
        
        int dist = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                int[]point = queue.poll();
            int r = point[0];
            int c = point[1];
            
            for(int[]d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(isSafe(matrix,nr,nc)){
                    if(matrix[nr][nc] == -1){
                       queue.add(new int[]{nr,nc});
                        matrix[nr][nc] = dist;
                        
                     }
                 }
                }
            }
           
            dist++;
        }
        
        return matrix;
    }
    
    private boolean isSafe(int[][]matrix,int i,int j){
        return (i >=0 && i < matrix.length && j >= 0 && j < matrix[0].length);
    }
}