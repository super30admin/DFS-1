class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix[0].length==0){
            return matrix;
        }
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        Queue<int[]> q= new LinkedList<>();
        
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    q.add(new int [] {i,j});
                }
                else{
                    // used to differentiate between 
                    matrix[i][j]=-1;
                }
            }
        }
        
        
        int [][] dirs ={{0,1},{0,-1},{-1,0},{1,0}};
        
        int dist=1;
        
        while(!q.isEmpty()){
        int size=q.size();
            for(int i=0;i<size;i++){
                int cur[] =q.poll();
                for (int [] dir :dirs){
                    int r=dir[0]+cur[0];
                    int c=dir[1]+cur[1];
                    
                    if(r>=0 &&c>=0 && r<m&&c<n&& matrix[r][c]==-1){
                        matrix[r][c]=dist;
                        q.add(new int[] {r,c});
                    }
                    
                }
            }
            dist++;
        }
        
        return matrix;
        
        
        
    }
}
