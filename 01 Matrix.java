01 Matrix


 Time: O(m*n)
 Space: O(m*n)
 
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        Queue<int[]> q = new LinkedList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int dist = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                } else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[][] dirs= new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                int[] curr= q.poll();                
                for(int[] dir:dirs){
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    
                    if(r>=0 && r<m && c >=0 && c < n && matrix[r][c] == -1){
                        matrix[r][c] = dist; //actual assigning of the distance happens here
                        q.add(new int[] {r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}