Execute in leet code-Yes
time complexity-o(m*n)
spcae complexity-o(m*n)

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m= matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q= new LinkedList<>();
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(matrix[i][j]==0)
                   q.add(new int[] {i,j});
               else
                   matrix[i][j]=-1;
           }
       }
        int distance =0;
        int[][] dirs = new int[][] {{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size= q.size();
            distance++;
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                for(int[] dir:dirs){
                                int r= cur[0]+dir[0];
                int c= cur[1]+dir[1];
                if(r>=0&&r<m&&c>=0&&c<n&&matrix[r][c]==-1){
                 matrix[r][c] = distance;
                 q.add(new int[] {r,c});   
                }    
                }

            }
        }
        return matrix;
    }
}
