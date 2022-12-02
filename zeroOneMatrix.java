// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0){ return mat;}
        int m= mat.length;
        int n=mat[0].length;
        int num=0;
        int level=1;
        Queue<Integer> row=new LinkedList<>();
        Queue<Integer> col=new LinkedList<>();
        int[][] dirs={{-1,0} , {1,0} , {0,-1} , {0,1}}; //U D L R
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    row.add(i);
                    col.add(j);
                    
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        
        while(!row.isEmpty()){
            
                int r= row.poll();
                int c= col.poll();
                for(int[] dir:dirs){
                    int rn= r + dir[0];
                    int cn= c + dir[1];
                    if(rn>=0 && cn>=0 && rn<m && cn<n && mat[rn][cn]==-1){
                        mat[rn][cn]=mat[r][c]+1;
                        row.add(rn);
                        col.add(cn);
                    }
                }
                
           
        }
        return mat;
    }
}