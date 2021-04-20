/*Time complexity: O(mn) 
Space Complexity: O(mn)

*/

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null|| matrix.length==0){
            return matrix;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int count=0;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                    
                }
                else{
                    count++;
                    matrix[i][j]=-1;
                }
            } 
            }
            if(count==0){
                return matrix;
        }
        
        int level=1;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            
           for(int i=0;i<size;i++){
               int[] curr=q.poll();
               for(int[] dire: dir){
                   int r= curr[0]+dire[0];
                   int c= curr[1]+dire[1];
                   if(r>=0 && c>=0 && r<m && c<n && matrix[r][c]==-1){
                      matrix[r][c]=level;
                       q.add(new int[] {r,c});
                   }
               }
           } 
            level++;
        }
        
        
        return matrix;
    }
}